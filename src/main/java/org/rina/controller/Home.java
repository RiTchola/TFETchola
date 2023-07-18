package org.rina.controller;

import org.rina.model.Professeur;
import org.rina.model.Roles;
import org.rina.model.User;
import org.rina.service.UserServices;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class Home {
	@Value("${spring.thymeleaf.encoding}")
	String thyme1;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("prof", "VO");
		model.addAttribute("cours", "PID");
		model.addAttribute("thyme", thyme1);
		return "home";
	}

	@GetMapping("/test")
	public @ResponseBody Professeur restMethode() {
		return new Professeur("VO", "Van Oudenhove", "Didier", new User("vo", "vo", Roles.ROLE_PROF));
	}

}
