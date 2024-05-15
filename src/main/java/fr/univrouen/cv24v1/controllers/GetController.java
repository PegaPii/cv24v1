package fr.univrouen.cv24v1.controllers;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import fr.univrouen.cv24v1.model.*;
import fr.univrouen.cv24v1.repository.CV24ResponseRepository;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cv24")
public class GetController {

	private Marshaller marshaller;
	private JAXBContext jaxbContext;

	@Autowired
	private cv24Repository cvRepository;

	@Autowired
	private CV24ResponseRepository responseRepository;

	@GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ListCV24 getCVListXML() throws JAXBException {
		List<cv24> list = new ArrayList<>();
		ListCV24 listcv24 = new ListCV24();

		list = cvRepository.findAll();
		if(!list.isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				cv24 cv = list.get(i);
				Identite identite = new Identite(cv.getIdentite().getGenre(), cv.getIdentite().getPrenom(),
												cv.getIdentite().getNom(), cv.getIdentite().getTel());
				Objectif objectif = new Objectif(cv.getObjectif().getStatut(), cv.getObjectif().getObjectif());
				Diplome diplome = cv.getCompetences().getDiplomeRecent();
				Competences competences = new Competences(diplome);

				cv.setIdentite(identite);
				cv.setObjectif(objectif);
				cv.setCompetences(competences);
				cv.setProf(null);
			}

			listcv24.setCv24(list);
			return listcv24;
		}
		return null;
	}

	@GetMapping("/resume")
	public ModelAndView getCVList() {
		List<cv24> cvList = cvRepository.findAll();
		ModelAndView mav = new ModelAndView("listcv");
		mav.addObject("cvList", cvList);
		return mav;
	}

	@GetMapping(path = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody String getDetailCVXML(@PathVariable(value = "id") int id) throws JAXBException {
		CV24Response response = new CV24Response();

		if(cvRepository.existsById((long) id)) {
			cv24 cv = cvRepository.getById((long) id);
			jaxbContext = JAXBContext.newInstance(cv24.class);
			marshaller = jaxbContext.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(cv, stringWriter);

			return stringWriter.toString();
		} else {
			response.setId((long) id);
			response.setStatus("ERROR");
			responseRepository.save(response);
			return "<message>" +
					"<id>" + id + "</id>" +
					"<status>" + HttpStatus.NOT_FOUND + "</status>" +
					"</message>";
		}
	}

	@GetMapping("/html/{id}")
	public ModelAndView getDetailCVHTML(@PathVariable(value = "id") int id) {
		cv24 cv = cvRepository.findById((long) id).orElse(null);
		CV24Response response = new CV24Response();
		if (cv == null) {
			response.setId((long) id);
			response.setStatus("ERROR");
			responseRepository.save(response);
			return new ModelAndView("error", "id", id);
		} else {
			ModelAndView modelAndView = new ModelAndView("cvdetail");
			modelAndView.addObject("cv", cv);
			return modelAndView;
		}
	}
}