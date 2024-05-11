package fr.univrouen.cv24v1.controllers;

import java.io.File;
import java.io.StringWriter;
import java.util.List;
import java.util.Optional;

import fr.univrouen.cv24v1.model.ListCV24;
import fr.univrouen.cv24v1.model.cv24;
import fr.univrouen.cv24v1.repository.cv24Repository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/cv24")
public class GetController {

	private Marshaller marshaller;
	private JAXBContext jaxbContext;

	@Autowired
	private cv24Repository cvRepository;

	@GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> getCVListXML() throws JAXBException {
		List<cv24> cvList = cvRepository.findAll();

		// Créer un Marshaller à partir du JAXBContext
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Créer un objet Java de type Cv24List pour envelopper la liste de CV
		ListCV24 cv24List = new ListCV24();
		cv24List.setCv24(cvList);

		// Marshaller l'objet Java en flux XML
		StringWriter writer = new StringWriter();
		marshaller.marshal(cv24List, writer);

		// Renvoyer le flux XML généré avec un code HTTP 200 (OK)
		return ResponseEntity.ok(writer.toString());
	}

	/*@GetMapping("/resume")
	public String getCVList(Model model) {
		List<cv24> cvList = cvRepository.findAll();
		model.addAttribute("cvList", cvList);
		return "listcv";
	}*/

	@GetMapping("/resume")
	public ModelAndView getCVList() {
		ModelAndView mav = new ModelAndView("listcv");
		return mav;
	}

	@GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public @ResponseBody ResponseEntity<String> getDetailCVXML(@RequestParam(value = "id") int id) throws JAXBException {
		Optional<cv24> cv = cvRepository.findById(Long.valueOf(id));
		if (cv == null) {
			// Renvoyer une réponse d'erreur avec un code HTTP 404 (Not Found)
			return ResponseEntity.notFound().build();
		}

		// Créer un Marshaller à partir du JAXBContext
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		// Marshaller l'objet Java en flux XML
		StringWriter writer = new StringWriter();
		marshaller.marshal(cv, writer);

		// Renvoyer le flux XML généré avec un code HTTP 200 (OK)
		return ResponseEntity.ok(writer.toString());

		/*if(cvRepository.existsById((long) id)) {
			Optional<cv24> cv = cvRepository.findById((long) id);
			jaxbContext = JAXBContext.newInstance(cv24.class);
			marshaller = jaxbContext.createMarshaller();
			StringWriter stringWriter = new StringWriter();
			marshaller.marshal(cv, stringWriter);

			return stringWriter.toString();
		} else {
			return "<message>" +
					"<id>" + id + "</id>" +
					"<status>" + HttpStatus.NOT_FOUND + "</status>" +
					"</message>";
		}*/
	}

	@RequestMapping("/html")
	public String getDetailCVHTML(@RequestParam(value = "id") int id, Model model) {
		if(cvRepository.existsById((long) id)) {
			cv24 cv = cvRepository.getById((long) id);

			model.addAttribute("cv", cv);
			return "cvdetail";
		} else {
			model.addAttribute("id", id);
			return "404";
		}

		/*cv24 cv = cvRepository.findById(id);
		if (cv == null) {
			return "cv24-not-found";
		}
		model.addAttribute("cv", cv);
		return "cvdetail";*/
	}

}
