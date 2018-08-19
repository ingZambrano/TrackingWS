package com.avior.controller;

import java.security.Principal;

import javax.annotation.Resource;
import javax.mail.internet.InternetAddress;
import javax.validation.Valid;

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
@RequestMapping("/")
public class HomeController {

	
	@RequestMapping(method = RequestMethod.GET)
	public String displayHome(Model model, Principal principal) {
		
		
		Comment comment = new Comment();
		model.addAttribute("commentForm", comment);
		model.addAttribute("pageType", "contact");
		model.addAttribute("menuItem", "contact");
		
		return "homePage";
	}
	
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
	
	
	
	@RequestMapping("/submit")
	public String rcvComment(@Valid @ModelAttribute("commentForm")Comment comment,
			BindingResult result, Principal principal, Model model){
		if(principal != null){
			Tavusuario loggedUser = userService.getUsuario(principal.getName());
			model.addAttribute("loggedUser", loggedUser);
		}
		if(result.hasErrors()){
			model.addAttribute("pageType", "template");
			return "mensajeError";
		}
		try{
			InternetAddress from = new InternetAddress(comment.getEmail());
			from.setPersonal(comment.getNombre());
			mailSvc.sendMail(from.toString(), comment.getComment());			
		}catch(Exception ex){
		
			model.addAttribute("errorMsg", ex.getLocalizedMessage());
			model.addAttribute("pageType", "template");
			return "mensajeError";
		}
		model.addAttribute("pageType", "template");
		return "mensajeCorrecto";
	}	
	

}
