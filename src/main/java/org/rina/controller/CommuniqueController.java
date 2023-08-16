package org.rina.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.rina.controller.dto.CommuniqueDto;
import org.rina.controller.exceptions.NotExistException;
import org.rina.model.Etablissement;
import org.rina.service.CommuniqueServices;
import org.rina.service.EtablissementServices;
import org.rina.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/communique")
public class CommuniqueController {

	private CommuniqueServices communiqueService;
	private EtablissementServices etablissementService;
	private UserServices userService;

	@Autowired
	public CommuniqueController(CommuniqueServices communiqueService, EtablissementServices etablissementService,
			UserServices userService) {
		this.communiqueService = communiqueService;
		this.etablissementService = etablissementService;
		this.userService = userService;
	}

	/**
	 * Liste des communique
	 * 
	 * @param model
	 * @return la nom logique de la vue qui affichera la liste des communique
	 */
	@GetMapping("/liste")
	public String listeCommunique(Model model) {
		model.addAttribute("communiqueList", communiqueService.findAllCommuniqueOrderByDateDesc());
		return "communique/listeCommunique";
	}

	/**
	 * Affiche le détail d'un communique
	 * 
	 * @param id
	 * @param model
	 * @param locale
	 * @return
	 */
	@GetMapping("/{id}")
	public String detailCommunique(@PathVariable Integer id, Model model, Locale locale) {
		log.debug("Recherche le communique: " + id);
		// si ce n'est pas une redirection, charge le communique
		if (!model.containsAttribute("communique"))
			// recherche le communique dans la liste et ajoute au model
			model.addAttribute("communique", CommuniqueDto
					.toDto(communiqueService.findById(id).orElseThrow(() -> new NotExistException(id.toString()))));
		return "communique/communique";
	}

	/**
	 * Méthode Get pour ajouter un communique
	 * 
	 * @param communique
	 * @return nom logique de la vue pour créer un communique
	 */
	@GetMapping("/add")
	public String addCommuniqueGet(@ModelAttribute("communique") CommuniqueDto communique) {
		log.debug("affiche la vue pour ajouter un communique ");
		return "communique/addCommunique";
	}

	/**
	 * Méthode Post pour créer le nouveau communique
	 * 
	 * @param communiqueDto le communique
	 * @param errors        les erreurs de validation
	 * @param rModel        une map qui peut survivre à une redirection
	 * @return une URL de redirection
	 */
	@PostMapping("/add")
	public String addCommuniquePost(@Valid @ModelAttribute("communique") CommuniqueDto communiqueDto,
			BindingResult errors, RedirectAttributes rModel) {
		log.info("POST d'un communique" + communiqueDto);
		// Gestion de la validation en fonction des annotations
		if (errors.hasErrors()) {
			log.debug("Erreurs dans les données du communique:" + communiqueDto.getNomEtablissement());
			return "communique/addCommunique";
		}
		// Vérifie que ce communique n'existe pas encore
		if (communiqueService.existsById(communiqueDto.getId())) {
			errors.rejectValue("id", "communique.id.doublon", "DUPLICATE ERROR");
			return "communique/addCommunique";
		}
		Etablissement etab = etablissementService.findOne(communiqueDto.getNomEtablissement())
				.orElseThrow(() -> new NotExistException(communiqueDto.getNomEtablissement()));
		communiqueService.insert(communiqueDto.toCommunique(etab));

		// Préparation des attributs Flash pour survivre à la redirection
		// Ainsi dans l'affichage du détail du communique on ne devra pas chercher le
		// communique dans la BD
		rModel.addFlashAttribute("communique", communiqueDto);

		log.debug("redirection communique/liste:");
		return "redirect:/communique/" + communiqueDto.getNomEtablissement();
	}

	/**
	 * Méthode Get pour afficher la page d'édition d'un communique
	 * 
	 * @param id    id du communique
	 * @param model auquel sera ajouté le savedID et le communique à modifier
	 * @return la vue logique
	 */
	@GetMapping("/{communique}/update")
	public String updateCommuniqueGet(@PathVariable(name = "communique") Integer id, Model model) {
		// rajoute le communiqueDTO ou déclenche une exception
		model.addAttribute("communique", CommuniqueDto
				.toDto(communiqueService.findById(id).orElseThrow(() -> new NotExistException(id.toString()))));
		// rajoute l'id du communique pour gérer la maj de ce dernier
		model.addAttribute("savedId", id);
		log.debug("affiche la vue pour modifier un communique ");
		return "communique/updateCommunique";
	}

	/**
	 * 
	 * @param id            désigne l'id du communique avant modification
	 * @param communiqueDto l'objet communique modifié
	 * @param errors        les erreurs de validation
	 * @param model         pour rajouter des attributs
	 * @param rModel        le modèle pour la redirection
	 * @return
	 */
	@PostMapping("{communique}/update")
	public String updateCommuniquePost(@PathVariable(name = "communique") Integer id,
			@ModelAttribute("communique") @Valid CommuniqueDto communiqueDto, BindingResult errors, Model model,
			RedirectAttributes rModel) {
		log.info("POST update d'un communique Id: " + id + " en " + communiqueDto);
		if (id == null)
			throw new NotExistException("null");
		// Gestion de la validation en fonction des annotations
		if (errors.hasErrors()) {
			// rajoute id pour savoir c'est l'id initial du communique
			model.addAttribute("savedId", id);
			log.info("Erreurs dans les données du communique:" + communiqueDto.getId());
			return "communique/updateCommunique";
		}
		// vérifie que l'id n'a pas changé et fait un update
		Etablissement etab = etablissementService.findByUsername(communiqueDto.getNomEtablissement())
				.orElseThrow(() -> new NotExistException(communiqueDto.getNomEtablissement()));
		if (communiqueDto.getId().equals(id))
			communiqueService.update(communiqueDto.toCommunique(etab));
		else // si l'id a changé vérifie que le nouveau id n'existe pas déjà
		if (communiqueService.existsById(communiqueDto.getId())) {
			// rajoute id pour savoir le id initial du communique
			model.addAttribute("savedId", id);
			errors.rejectValue("id", "communique.id.doublon", "DUPLICATE ERROR");
			return "communique/updateCommunique";
		} else { // supprime l'objet avec l'ancien id et rajoute le nouveau
			communiqueService.deleteById(id);
			communiqueService.insert(communiqueDto.toCommunique(etab));
		}

		// Pr�paration des attributs détail du communique on ne devra pas chercher le
		// communique dans la BD
		rModel.addFlashAttribute("communique", communiqueDto);

		log.debug("redirection détail du communique");
		return "redirect:/communique/" + communiqueDto.getId();
	}

	/**
	 * Supression d'un communique
	 * 
	 * @param id du communique
	 * @return le mapping de redirection
	 */
	@PostMapping("/{id}/delete")
	public String deleteCommunique(@PathVariable Integer id) {
		if (communiqueService.existsById(id))
			communiqueService.deleteById(id);
		else
			throw new NotExistException(id.toString());
		log.debug("Supression du communique: " + id);
		return "redirect:/communique/liste";
	}
	
	@ModelAttribute("userEtablissement")
	private List<String> getUsernameEtab() {
		return userService.getUsernameEtab();
	}

}
