package org.rina.controller;

import org.rina.model.PersonneContact;


import org.rina.model.Roles;
import org.rina.model.User;
import org.rina.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Home {
//	@Value("${spring.thymeleaf.encoding}")
//    String thyme1;
//	
	private UserServices userService;

	@Autowired
	public Home(UserServices userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String home(Model model) {
//		model.addAttribute("prof", "VO");
//		model.addAttribute("cours","PID");
//		model.addAttribute("module", "MODULE");
//		model.addAttribute("thyme", thyme1);
		return "home";
	}
	
	/*
	 * //a corriger
	 * 
	 * @GetMapping("/test") public @ResponseBody Famille restMethode() { return new
	 * Famille(null, "VO", "Van Oudenhove", null, "Didier",thyme1, thyme1, thyme1,
	 * new User("vo","vo",Roles.ROLE_FAMILLE), null); }
	 */
	
	/**
	 * 
	 * Permet de vérifier si un username existe déjà actuellement en mode Get, on
	 * peut la transformer en Post pour éviter que n'importe qui teste l'existance
	 * des usernames
	 * 
	 * @param username
	 * @return true ou false
	 */
	@GetMapping("/check/{username}")
	public @ResponseBody boolean isValid(@PathVariable("username") String username) {
		return userService.existsById(username);
	}
}
