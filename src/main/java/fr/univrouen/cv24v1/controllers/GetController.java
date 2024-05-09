package fr.univrouen.cv24v1.controllers;

import java.io.File;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.model.CV;
import fr.univrouen.cv24.util.Fichier;
import fr.univrouen.cv24.util.FichierCV;

@RestController
public class GetController {
	
	@GetMapping("/resume")
	public String getListCVinXML() {
		return "Envoi de la liste des CV";
	}
	
	@GetMapping("/cvid")
	public String getCVinXML(
		@RequestParam(value = "texte") String texte) {
		return ("Détail du CV n°" + texte);
	}
	
	@GetMapping("/test")
	public String getTest(
		@RequestParam(value = "id") int id,
		@RequestParam(value = "titre") String titre) {
		return ("Test : <br>" + "id = " + id + "<br>titre = " + titre);
	}
	
	@GetMapping("/testfic")
	public String getFichier() {
		Fichier fichier = new Fichier();
		return fichier.loadFileXML();
	}
	
	@RequestMapping(value="/testxml", produces=MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody CV getXML() {
		CV cv = new CV();
		return cv;
	}
	
	@GetMapping("/testcv")
	public String getFichierCV() {
		FichierCV fichier = new FichierCV();
		return fichier.loadFileXML();
	}
}
