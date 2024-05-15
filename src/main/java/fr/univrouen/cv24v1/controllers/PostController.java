package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.model.*;
import fr.univrouen.cv24v1.repository.CV24ResponseRepository;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.repository.identiteRepository;
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
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cv24")
public class PostController {

	@Autowired
	private cv24Repository cvRepository;
	@Autowired
	private identiteRepository identiteRepository;

	@Autowired
	private CV24ResponseRepository responseRepository;
	@Autowired
	private CVService cvService;


	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = "application/xml",
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> insert(@RequestBody String xml) throws JAXBException, SAXException, IOException {
		CV24Response response = new CV24Response();
		if (!cvService.validateXML(xml)) {
			response.setStatus("ERROR");
			response.setDetail("INVALID");
			responseRepository.save(response);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(cvService.responseToXml(response));
		}

		cv24 cv = cvService.stringToCv(xml);

		// Vérifier si le CV existe déjà dans la base de données
		Identite testIdentite = identiteRepository.findByGenreAndNomAndPrenomAndTel(cv.getIdentite().getGenre(),
				cv.getIdentite().getNom(), cv.getIdentite().getPrenom(), cv.getIdentite().getTel());
		if (testIdentite != null) {
			response.setStatus("ERROR");
			response.setDetail("DUPLICATED");
			responseRepository.save(response);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(cvService.responseToXml(response));
		}
		System.out.println("cv :");
		System.out.println(cv.getIdentite().getGenre());

		// Enregistrer le CV dans la base de données
		cvRepository.save(cv);

		response.setId(cv.getId());
		response.setStatus("INSERTED");
		String result = cvService.responseToXml(response);
		responseRepository.save(response);
		// Renvoyer le flux XML généré avec un code HTTP 201 (Créé)
		return ResponseEntity.status(HttpStatus.CREATED).body(result.toString());
	}


	@RequestMapping(value = "/insertTest", method = RequestMethod.POST, consumes = "application/xml",
			produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> insertTest(@RequestBody String xml) throws JAXBException, SAXException, IOException {
		CV24Response response = new CV24Response();
		if (!cvService.validateXML(xml)) {
			response.setStatus("ERROR");
			response.setDetail("INVALID");
			responseRepository.save(response);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(cvService.responseToXml(response));
		}

		cv24 cv = cvService.stringToCv(xml);

		// Vérifier si le CV existe déjà dans la base de données
		Identite testIdentite = identiteRepository.findByGenreAndNomAndPrenomAndTel(cv.getIdentite().getGenre(),
				cv.getIdentite().getNom(), cv.getIdentite().getPrenom(), cv.getIdentite().getTel());
		if (testIdentite != null) {
			response.setStatus("ERROR");
			response.setDetail("DUPLICATED");
			responseRepository.save(response);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(cvService.responseToXml(response));
		}

		// Enregistrer le CV dans la base de données
		cvRepository.saveAndFlush(cv);
		List<cv24> l = cvRepository.findAll();
		StringBuffer sb = new StringBuffer();
		ListCV24 list = new ListCV24();
		List<cv24> subl = new ArrayList<cv24>();
		System.out.println("nb de cv trouvés : " + l.size());
		for(cv24 cvl : l){
			System.out.println("id de cv : " + cvl.getId());
			cvRepository.getById(cvl.getId());
			cvl.debug();
			subl.add(cvl);
		}
		list.setCv24(subl);
		// Renvoyer le flux XML généré avec un code HTTP 201 (Créé)
		return ResponseEntity.status(HttpStatus.CREATED).body(cvService.CvListToString(list));
	}
}

