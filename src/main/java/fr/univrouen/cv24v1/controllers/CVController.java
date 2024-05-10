package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.model.cv24;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.service.CVService;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
public class CVController {
    @Autowired
    private CVService cvService;

    @Autowired
    private cv24Repository cvRepository;



    @PostMapping(value="/insert", consumes = "application/xml", produces = "application/xml")
    public ResponseEntity<String> insertCv(@RequestBody String body) throws JAXBException, IOException, SAXException {
        // Valider les données du CV en utilisant le schéma XSD

        if(!cvService.validateXML(body)){
            System.out.println("caca");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("caca");

        }
        else{
            cv24 cv = cvService.stringToCv(body);
            cv.debug();
            //cvRepository.save(cv);
            // Renvoyer le CV enregistré avec un code HTTP 201 (Créé)
            return ResponseEntity.status(HttpStatus.CREATED).body(body);

        }

    }

    /*@GetMapping("/{id}")
    public cv24 getCVById(@PathVariable Long id) {
        return cvRepository.findById(id);
    }

    @PutMapping("/update")
    public String updateCV(@RequestBody cv24 cv) {
        cvRepository.save(cv);
        return "CV mis à jour avec succès";
    }

    @DeleteMapping("/{id}")
    public String deleteCV(@PathVariable Long id) {
        cv24 cv = cvRepository.findById(id);
        cvRepository.delete(cv);
        return "CV supprimé avec succès";
    }*/

}

