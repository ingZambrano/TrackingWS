package com.avior.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.avior.model.jpa.Cliente;
//import com.avior.model.jpa.User;
import com.avior.model.tav.Tavusuario;
import com.avior.model.web.ChangePassRet;
import com.avior.model.web.ResetPasswordForm;
import com.avior.services.MailService;
import com.avior.services.ManageUsers;

@Controller
@RequestMapping("/auth")
public class LoginLogoutController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="rstPwdValidator")
	Validator rstPwdValidator;
	
	@InitBinder("resetForm")
	public void initBinder(final WebDataBinder binder){
		binder.setValidator(rstPwdValidator);
	}

	@Autowired
	private ShaPasswordEncoder passwordEncoder;	
	
	@Autowired
	private ManageUsers userSvc;
	
	@Autowired
	private MailService mailSvc;
	
	@RequestMapping("/login" )
	public String login(Model model){
		
		model.addAttribute("msj_error", "Usuario y/o contraseña invalidos");
		model.addAttribute("pageType", "principal");
		model.addAttribute("menuItem", "home");
		return "home";
	}	
	
	@RequestMapping(value="/forgot", method = RequestMethod.GET)
	public String showResetPasswordForm(Model model){
		model.addAttribute("resetForm", new ResetPasswordForm());
		model.addAttribute("pageType", "template");
		return "resetpass";
	}
	
	@RequestMapping(value="/resetpass", method = RequestMethod.GET)
	public String showRenovarPass(Principal principal, Model model){
		Tavusuario theUser = userSvc.getUsuario(principal.getName());
		model.addAttribute("loggedUser", theUser);	
		model.addAttribute("chgPassword", true);
		return "renovarpass";
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public String resetPassword(@Valid @ModelAttribute("resetForm") ResetPasswordForm rpf,
			BindingResult result,
			Model model){
	
		if(result.hasErrors()){
			logger.info("Errores en el form, regresando a la misma pagina");
			return "resetpass";
		}
		
		char [] permittedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ï¿½?+-_.*,;$&/()=".toCharArray(); 
		String s = RandomStringUtils.random(8, permittedChars);
		String email = rpf.getEmail();
		
		mailSvc.sendMail(email, "Reestablecimiento de contraseña", 
				"Que tal, usted ha solicitado el reestablecimiento de su contraseña.\r\n\r\n Su nueva contraseña es: " + s
				+ "\r\n\r\n Ahora puede ingresar de manera segura usando esta nueva contraseña. Una vez iniciada su sesión puede modificarla en la sección \"Mi cuenta\"");		
		
		String hash = passwordEncoder.encodePassword(s, rpf.getEmail());			
				
		Tavusuario u = userSvc.getUsuario(rpf.getEmail());
		u.setFcPassword(hash);
		userSvc.updateusuario(u);
			
		return "redirect:/auth/login";
	}
	@RequestMapping(value = "/changepwd", method = RequestMethod.GET)
	public @ResponseBody	
	ChangePassRet changePasswordGET(Principal principal, String oldPass, String newPass, HttpServletResponse response){
		
		ChangePassRet ret = new ChangePassRet();
		//String result= "{status: 0, message: \"\"}\r\n";
		if(principal == null){
			ret.setErrorcode(1);
			ret.setMessage("Not logged in");
			ret.setStatus("1");
			//result="{status: 1, errorcode: 1,  message: \"Not logged in\"}\r\n";			
		} else if(newPass.length() < 8 || newPass.length() > 16){
			ret.setErrorcode(2);
			ret.setMessage("Wrong length. New password must be between 8 and 16 characters long");
			ret.setStatus("1");
			//result="{status: 1, errorcode: 2, message: \"Wrong length. New password must be between 8 and 16 characters long\"}\r\n";
		}else{
			//User theUser = userSvc.getUser(principal.getName());
			Tavusuario theUser = userSvc.getUsuario(principal.getName());
			String hash = passwordEncoder.encodePassword(oldPass, theUser.getUsername());
			if(theUser.getPassword().equalsIgnoreCase(hash)){
				logger.debug("Usuario " + theUser.getUsername() + " cambio de contraseï¿½a.");
				//Cambia las contraseï¿½as
				String newHash = passwordEncoder.encodePassword(newPass, theUser.getUsername());
//				theUser.setPassword(newHash);
//				userSvc.updateUser(theUser);	
				theUser.setFcPassword(newHash);
				userSvc.updateusuario(theUser);
				ret.setErrorcode(0);
				ret.setMessage("Password successfully changed.");
				ret.setStatus("0");
				//result="{status: 0, errorcode: 0, message: \"Password successfully changed.\"}\r\n";
			}else{
				ret.setErrorcode(3);
				ret.setMessage("Current and new password do not match.");
				ret.setStatus("1");
				//result="{status: 1, errorcode: 3, message: \"Current and new password do not match.\"}\r\n";
			}			
		}		
		response.setCharacterEncoding("UTF-8");
		
		
		return ret;
		
	}
	/**
	 * Acepta una peticiï¿½n POST para cambiar la contraseï¿½a de un usuario loggeado
	 * @param principal El objeto principal con la sesiï¿½n del usuario
	 * @param oldPass La actual contraseï¿½a del usuario
	 * @param newPass La nueva contraseï¿½a
	 * @return Cï¿½digo de status
	 */
	@RequestMapping(value="/changepwd", method=RequestMethod.POST)
	public @ResponseBody
	String changePassword(Principal principal, String oldPass, String newPass, HttpServletResponse response){
		String result= "{status: 0, message: \"\"}\r\n";
		if(principal == null){
			result="{status: 1, errorcode: 1,  message: \"Not logged in\"}\r\n";			
		} else if(newPass.length() < 8 || newPass.length() > 16){
			result="{status: 1, errorcode: 2, message: \"Wrong length. New password must be between 8 and 16 characters long\"}\r\n";
		}else{
			//User theUser = userSvc.getUser(principal.getName());
			Tavusuario theUser = userSvc.getUsuario(principal.getName());
			String hash = passwordEncoder.encodePassword(oldPass, theUser.getUsername());
			if(theUser.getPassword().equalsIgnoreCase(hash)){
				logger.debug("Usuario " + theUser.getUsername() + " cambio de contraseï¿½a.");
				//Cambia las contraseï¿½as
				String newHash = passwordEncoder.encodePassword(newPass, theUser.getUsername());
//				theUser.setPassword(newHash);
//				userSvc.updateUser(theUser);	
				theUser.setFcPassword(newHash);
				userSvc.updateusuario(theUser);
				result="{status: 0, errorcode: 0, message: \"Password successfully changed.\"}\r\n";
			}else{
				result="{status: 1, errorcode: 3, message: \"Current and new password do not match.\"}\r\n";
			}			
		}		
		response.setCharacterEncoding("UTF-8");
		return result;
	}
	/**
	 * En caso de que el usuario olvide su contraseï¿½a, se provee este mï¿½todo similar a resetPassword; 
	 * sin embargo, ï¿½ste mï¿½todo estï¿½ diseï¿½ado para responder con JSON.
	 * @param email El email del usuario.
	 * @param user El nombre de usuario que utiliza para inciar sesiï¿½n
	 * @return Un objeto JSON con el status y error (si aplica)
	 */
	@RequestMapping(value="/resetpwd", method=RequestMethod.POST)
	public @ResponseBody
	String resetPassword(String email, String user){
		String result="";
		//User theUser = null;
		Tavusuario theUser = null;
		char [] permittedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890ï¿½?+-_.*,;$&/()=".toCharArray(); 
		String s = RandomStringUtils.random(8, permittedChars);
		if (email==null || "".equals(email)){
			result="{status=1, errorcode=1, message: \"No email was provided\"}";
		}else if(user==null || "".equals(user)){
			result="{status=1, errorcode=2, message: \"No username was provided\"}";
		}else {
			//theUser = userSvc.getUser(user);
			theUser = userSvc.getUsuario(user);
			if(theUser == null){
				result="{status=1, errorcode=3, message: \"The user provided does not exists.\"}";
			}else{
				
					String hash = passwordEncoder.encodePassword(s, theUser.getUsername());
					theUser.setFcPassword(hash);
					userSvc.updateusuario(theUser);
					mailSvc.sendMail(email, "Reestablecimiento de contraseï¿½a", 
							"Que tal, usted ha solicitado el reestablecimiento de su contraseï¿½a.\r\n\r\n Su nueva contraseï¿½a es: " + s
							+ "\r\n\r\n Ahora puede ingresar de manera segura usando esta nueva contraseï¿½a. Una vez iniciada su sesiï¿½n puede modificarla en la secciï¿½n \"Mi cuenta\"");
					
					result="{status=0, errorcode=0, message: \"Password succesfully reset, check your email.\"}";
				
			}
		}				
		return result;
	}
	
	
}
