

package fr.univrouen.cv24v1.controllers;

import java.io.File;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.univrouen.cv24.model.CV;
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
}
