package org.rina.controller;

import java.io.File;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.validation.Valid;

import org.rina.controller.exceptions.NotExistException;
import org.rina.model.Fichier;
import org.rina.model.PersonneContact;
import org.rina.controller.dto.FichierDto;
import org.rina.service.FichierServices;
import org.rina.service.PersonneContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/fichier")
public class FichierController {

	private FichierServices fichierService;
	private PersonneContactServices personCService;

	@Autowired
	public FichierController(FichierServices fichierService, PersonneContactServices personCServices) {
		this.fichierService = fichierService;
		this.personCService = personCService;
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
	@GetMapping("/add/{idpc}")
	public String addFichierGet(@PathVariable Integer idpc, @ModelAttribute("fichier") FichierDto fichierDto,
			Model model) {

		log.debug("affiche la vue pour ajouter un fichier ");
		String fileName = StringUtils.cleanPath(fichierDto.getFile().getOriginalFilename());
		model.addAttribute("nomFichier", fileName);
		
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
	@PostMapping("/add/{idpc}")
	public String addFichierPost(@PathVariable Integer idpc, @Valid @ModelAttribute("fichier") FichierDto fichierDto,
			BindingResult errors, Model model) {

		log.info("POST d'un fichier" + fichierDto);
		// Gestion de la validation en fonction des annotations
		if (errors.hasErrors()) {
			log.debug("Erreurs dans les données du fichier:" + fichierDto.getId());

			return "fichier/addFichier";
		}

		// vérifie que le fichier n'est pas vide
		MultipartFile file = fichierDto.getFile();

		if (file.isEmpty()) {
			errors.rejectValue("Attention", "fichier.file.empty", "EMPTY ERROR");
			return "fichier/addFichier";
		}
		
		String fileName = fichierDto.getNomFichier();
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);

			log.info("You successfully uploaded '" + fileName + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		PersonneContact persC = personCService.findById(idpc).orElseThrow(() -> new NotExistException(idpc.toString()));
		Fichier fic = fichierDto.toFichier(persC);
		fichierService.insert(fic);

		log.info("successfully '" + fic.getId());
		return "redirect:/fichier/liste";
	}

	/**
	 * téléchargement d'un fichier
	 * 
	 * @param id du fichier
	 * @return le mapping de redirection
	 */
	@GetMapping(path = "/download/{nomFichier}")
	public ResponseEntity<Resource> downloadFichierGet(@PathVariable("nomFichier") String nomFichier, @Valid @ModelAttribute("fichier") FichierDto fichierDto) throws IOException {
		
		File fileD = new File(UPLOADED_FOLDER + nomFichier);
		Path path = Paths.get(fileD.getAbsolutePath());
		ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

		return ResponseEntity.ok().headers(this.headers(nomFichier)).contentLength(fileD.length())
				.contentType(MediaType.parseMediaType("application/octet-stream")).body(resource);
	}

	/**
	 * Supression d'un fichier
	 * 
	 * @param id du fichier
	 * @return le mapping de redirection
	 */
	@PostMapping("/{id}/delete")
	public String deleteFichier(@PathVariable Integer id) {
		Optional<Fichier> fic = fichierService.findById(id);
		String fileName = fic.get().getNomFichier();

		if (fichierService.existsById(id))
			fichierService.deleteById(id);
		else
			throw new NotExistException(id.toString());
		log.debug("Suppression réussie du fichier: " + id);
		try {
			Files.deleteIfExists(Paths.get(UPLOADED_FOLDER + fileName));
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

	@ModelAttribute("username")
	private String getUsername() {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		return username;
	}
}
