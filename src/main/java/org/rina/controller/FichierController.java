package org.rina.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.rina.controller.exceptions.NotExistException;
import org.rina.model.Fichier;
import org.rina.controller.dto.FichierDto;
import org.rina.service.FichierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/fichier")
public class FichierController {

	private FichierServices fichierService;

	@Autowired
	public FichierController(FichierServices fichierService) {
		this.fichierService = fichierService;
	}

	// Save the uploaded file to this folder
	private static String UPLOADED_FOLDER = "/MPAC2223/src/main/resources/static/files";

	/**
	 * Liste des fichiers
	 * 
	 * @param model
	 * @return la nom logique de la vue qui affichera la liste des fichiers
	 */
	@GetMapping("/liste")
	public String listeFichier(Model model) {
		model.addAttribute("fichierList", fichierService.findAllFichierOrderByDateDesc());
		return "fichier/listeFichier";
	}

	/**
	 * Methode Get pour ajouter un fichier
	 * 
	 * @param fichier un fichier avec des valeurs par défaut
	 * @return nom logique de la vue pour créer un fichier
	 */
	@GetMapping("/add")
	public String addFichierGet(@ModelAttribute("fichier") FichierDto fichier) {
		log.debug("affiche la vue pour ajouter un fichier ");
		return "fichier/addFichier";
	}

	/**
	 * Méthode Post pour ajouter le nouveau fichier
	 * 
	 * @param fichier le fichier
	 * @param errors  les erreurs de validation
	 * @param rModel  une map qui peut survivre à une redirection
	 * @return une URL de redirection
	 */
	@PostMapping("/add")
	public String addFichierPost(@Valid @ModelAttribute("file") FichierDto fichierDto, BindingResult errors,
			Model model) {
		log.info("POST d'un fichier" + fichierDto);
		// Gestion de la validation en fonction des annotations
		if (errors.hasErrors()) {
			log.debug("Erreurs dans les données du fichier:" + fichierDto.getId());
			return "fichier/addFichier";
		}

		// vérifie que le fichier n'est pas vide
		if (fichierDto.getFile().isEmpty()) {
			errors.rejectValue("Attention", "fichier.file.empty", "EMPTY ERROR");
			return "fichier/addFichier";
		}

		try {

			byte[] bytes = fichierDto.getFile().getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fichierDto.getFile().getOriginalFilename());
			Files.write(path, bytes);

			log.info("You successfully uploaded '" + fichierDto.getFile().getOriginalFilename() + "'");

		} catch (IOException e) {
			model.addAttribute("error", "Error");
			return "fichier/addFichier";
		}

		List<String> list = new ArrayList<String>();
		File files = new File(UPLOADED_FOLDER);
		String[] fileList = ((File) files).list();
		for (String name : fileList) {
			list.add(name);
		}
		model.addAttribute("fichierList", fichierService.findAllFichierOrderByDateDesc());
		return "fichier/addFichier";
	}

	/**
	 * Supression d'un fichier
	 * 
	 * @param id du fichier
	 * @return le mapping de redirection
	 */
	@PostMapping("/{code}/delete")
	public String deleteFichier(@PathVariable Integer id) throws IOException {

		if (fichierService.existsById(id)) {
			Optional<Fichier> fic = fichierService.findById(id);
			
			fichierService.deleteById(id);}
		else
			throw new NotExistException(id.toString());
		log.debug("Suppression réussie du fichier: " + id);
		try {
			Files.deleteIfExists(Paths.get(UPLOADED_FOLDER + ));
		}

		catch (IOException e) {
			return "redirect:/fichier/liste";
		}
		return "redirect:/fichier/liste";
	}

	private HttpHeaders headers(String name) {

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + name);
		header.add("Cache-Control", "no-cache, no-store," + " must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return header;

	}
}
