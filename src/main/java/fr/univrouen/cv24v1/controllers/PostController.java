package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.model.*;
import fr.univrouen.cv24v1.repository.CVRepository;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

@RestController
@RequestMapping("/cv24")
public class PostController {

	@Autowired
	private CVRepository cvRepository;

	JAXBContext jaxbContext;
	Unmarshaller unmarshaller;

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/xml",
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> insert(@RequestBody String xml) throws JAXBException, SAXException, IOException {

		cv24 cv = (cv24) unmarshaller.unmarshal(new StringReader(xml));

		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new StreamSource(new ClassPathResource("/xsd/cv24.tp1.xsd").getInputStream()));
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource(new StringReader(xml)));

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

