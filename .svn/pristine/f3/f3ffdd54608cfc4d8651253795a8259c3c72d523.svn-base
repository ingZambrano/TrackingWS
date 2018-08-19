package com.avior.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.avior.model.tav.Tavusuario;
import com.avior.model.web.Comment;
import com.avior.services.MailService;
import com.avior.services.ManageUsers;

@Controller
@RequestMapping("/about")
public class CommentsController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private ManageUsers userService;
	private MailService mailSvc;
	
	@Resource(name="commentValidator")
	Validator commentValidator;
	
	@InitBinder("commentForm")
	public void initBinder(final WebDataBinder binder){
		binder.setValidator(commentValidator);
	}
	
	@Autowired
	public void setMailSvc(MailService svc){
		this.mailSvc = svc;
	}
	
	@Autowired
	public void setUserService(ManageUsers usrSvc){
		this.userService = usrSvc;
	}
	
	
	/**
	 * Metodo principal, genera la vista de Mision/Vision
	 * @param model   El modelo actual
	 * @param principal El contenedor de credenciales
	 * @return  El nombre de la vista a generar
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String about(Model model, Principal principal){
		if(principal != null){
			Tavusuario theUser = userService.getUsuario(principal.getName());
			model.addAttribute("loggedUser", theUser);
		}
		model.addAttribute("pageType", "template");
		model.addAttribute("menuItem", "about");
		return "about";
	}
	
	@RequestMapping("/contacto")
	public String contact(Model model, Principal principal){
		Comment comment = new Comment();
		model.addAttribute("commentForm", comment);
		model.addAttribute("pageType", "contact");
		model.addAttribute("menuItem", "contact");
		return "contact";
	}
	
	@RequestMapping("/submit")
	public String rcvComment(@Valid @ModelAttribute("commentForm")Comment comment,
			BindingResult result, Principal principal, Model model){
		if(principal != null){
			Tavusuario loggedUser = userService.getUsuario(principal.getName());
			model.addAttribute("loggedUser", loggedUser);
		}
		if(result.hasErrors()){
			logger.debug("Datos no validos en el comentario");
			logger.debug("Errores: " + result.getModel().get("org.springframework.validation.BindingResult.commentForm"));
			model.addAttribute("pageType", "template");
			return "about";
		}
		try{
			InternetAddress from = new InternetAddress(comment.getEmail());
			from.setPersonal(comment.getNombre());
			mailSvc.sendMail(from.toString(), comment.getComment());			
		}catch(Exception ex){
			logger.info(ex.getMessage());
			model.addAttribute("errorMsg", ex.getLocalizedMessage());
			model.addAttribute("pageType", "template");
			return "error";
		}
		model.addAttribute("pageType", "template");
		return "commentSuccess";
	}
}
