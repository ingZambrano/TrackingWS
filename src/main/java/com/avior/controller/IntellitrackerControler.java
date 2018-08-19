package com.avior.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avior.model.tav.Tavusuario;
import com.avior.services.ManageUsers;

@Controller
@RequestMapping("/intellitracker")
public class IntellitrackerControler {

	private ManageUsers userService;

	@Autowired
	public void setUserService(ManageUsers theService) {
		this.userService = theService;
	}

	@RequestMapping
	public String displayHome(Model model, Principal principal) {

		if (principal != null) {
			Tavusuario theUser = userService.getUsuario(principal.getName());
			model.addAttribute("loggedUser", theUser);
		}
		model.addAttribute("pageType", "principal");
		model.addAttribute("menuItem", "home");

		return "home";

	}


	@RequestMapping("ubicacion")
	public String showLocation(Model model, Principal principal) {
		if (principal != null) {// Esta url puede ser accedida por cualquiera,
								// asi que principal puede ser null
			model.addAttribute("loggedUser",
					userService.getUsuario(principal.getName()));
		}
		return "location";
	}
}
