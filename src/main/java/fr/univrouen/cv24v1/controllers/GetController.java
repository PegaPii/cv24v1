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
import fr.univrouen.cv24v1.service.CVService;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
	@Autowired
	private CVService cvService;

	@GetMapping(value = "/resume/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> getCVListXML() throws JAXBException {
		List<cv24> list = new ArrayList<>();
		list = cvRepository.findAll();
		ListCV24 listcv24 = new ListCV24();
		listcv24.setCv24(list);
		return ResponseEntity.status(HttpStatus.OK).body(cvService.CvListToString(listcv24));

	}

	@GetMapping("/resume")
	public ModelAndView getCVList() {
		List<cv24> cvList = cvRepository.findAll();
		ModelAndView mav = new ModelAndView("listcv");
		mav.addObject("cvList", cvList);
		return mav;
	}

	@GetMapping(path = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<String> getDetailCVXML(@RequestParam(value = "id") Long id) throws JAXBException {
		Optional<cv24> cv = cvRepository.findById(id);
		if(cv.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(cvService.CvToString(cv.get()));
		} else {
			CV24Response response = new CV24Response();
			response.setId(id);
			response.setStatus("ERROR");
			responseRepository.save(response);
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(cvService.responseToXml(response));
		}
	}

	@GetMapping("/html")
	public ModelAndView getDetailCVHTML(@RequestParam(value = "id") int id) {
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