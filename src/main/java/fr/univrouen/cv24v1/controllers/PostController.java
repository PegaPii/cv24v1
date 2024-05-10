package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.model.*;
import fr.univrouen.cv24v1.repository.CVRepository;
import fr.univrouen.cv24v1.service.CVService;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringWriter;

@RestController
@RequestMapping("/cv24")
public class PostController {

	@Autowired
	private CVRepository cvRepository;

	@Autowired
	private CVService cvService;

	JAXBContext jaxbContext;

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/xml",
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> insert(@RequestBody String xml) throws JAXBException, SAXException, IOException {

		if (!cvService.validateXML(xml)) {
			// Renvoyer une réponse d'erreur avec un code HTTP 400 (Bad Request)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("<result><status>ERROR</status><message>Invalid XML format</message></result>");
		}

		cv24 cv = cvService.stringToCv(xml);

		// Vérifier si le CV existe déjà dans la base de données
		cv24 existingCv = cvRepository.findByGenreAndNomAndPrenomAndTel(cv.getIdentite().getGenre(),
				cv.getIdentite().getNom(), cv.getIdentite().getPrenom(), cv.getIdentite().getTel());
		if (existingCv != null) {
			// Renvoyer une réponse d'erreur avec un code HTTP 409 (Conflit)
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body("<result><status>ERROR</status><message>CV already exists</message></result>");
		}

		// Générer un nouvel identifiant unique pour le CV
		Long newId = cvRepository.count() + 1;
		cv.setId(Math.toIntExact(newId));

		// Enregistrer le CV dans la base de données
		cvRepository.save(cv);

		// Créer un objet Java de type Cv24Response avec les informations id et status
		CV24Response response = new CV24Response();
		response.setId(newId);
		response.setStatus("INSERTED");

		// Créer un Marshaller à partir du JAXBContext
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshaller l'objet Java en flux XML
		StringWriter writer = new StringWriter();
		marshaller.marshal(response, writer);

		// Renvoyer le flux XML généré avec un code HTTP 201 (Créé)
		return ResponseEntity.status(HttpStatus.CREATED).body(writer.toString());
	}
}

