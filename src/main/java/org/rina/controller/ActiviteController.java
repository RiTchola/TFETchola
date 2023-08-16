package org.rina.controller;

import org.rina.service.ActiviteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/activite")
public class ActiviteController {
	
	private ActiviteServices activiteService;

	@Autowired 
	public ActiviteController(ActiviteServices activiteService) {
		this.activiteService = activiteService;
	}
	
	/**
	 * Liste des activités
	 * @param model
	 * @return la nom logique de la vue qui affichera la liste des activités
	 */
	@GetMapping("/liste")
	public String listeActivite(Model model) {
		model.addAttribute("activiteList", activiteService.findAll());
		return "activite/listeActivite";
	}

}
