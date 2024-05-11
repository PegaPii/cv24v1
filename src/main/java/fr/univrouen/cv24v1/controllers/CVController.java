package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.model.cv24;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.service.CVService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import java.io.IOException;

@RestController
@RequestMapping("/cv")
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
            cvRepository.save(cv);
            // Renvoyer le CV enregistré avec un code HTTP 201 (Créé)
            return ResponseEntity.status(HttpStatus.CREATED).body(body);

        }

    }

    @GetMapping("/{id}")
    public cv24 getCVById(@PathVariable Long id) {

        return cvRepository.getById(id);
    }

    @PutMapping("/update")
    public String updateCV(@RequestBody cv24 cv) {
        cvRepository.save(cv);
        return "CV mis à jour avec succès";
    }

    @DeleteMapping("/{id}")
    public String deleteCV(@PathVariable Long id) {
        cv24 cv = cvRepository.getById(id);
        cvRepository.delete(cv);
        return "CV supprimé avec succès";
    }

}

