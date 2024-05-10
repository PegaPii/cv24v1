package fr.univrouen.cv24v1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fr.univrouen.cv24v1.repository.CVRepository;
import fr.univrouen.cv24.model.CV;

@RestController
@RequestMapping("/cv24")
public class CVController {

    /*@Autowired
    private CVRepository cvRepository;

    @PostMapping("/insert")
    public String addCV(@RequestBody CV cv) {
        cvRepository.save(cv);
        return "CV ajouté avec succès";
    }

    @GetMapping("/{id}")
    public CV getCVById(@PathVariable Long id) {
        return cvRepository.findById(id);
    }

    @PutMapping("/update")
    public String updateCV(@RequestBody CV cv) {
        cvRepository.save(cv);
        return "CV mis à jour avec succès";
    }

    @DeleteMapping("/{id}")
    public String deleteCV(@PathVariable Long id) {
        CV cv = cvRepository.findById(id);
        cvRepository.delete(cv);
        return "CV supprimé avec succès";
    }*/
}

