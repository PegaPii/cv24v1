package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.repository.CVRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    private CVRepository cvRepository;

    @DeleteMapping("/delete")
    public String delete(@RequestParam(value = "id") int id) {
        if(cvRepository.existsById((long) id)) {
            cvRepository.deleteById((long) id);

            return "<message>" +
                    "<id>" + id + "</id>" +
                    "<status>" + HttpStatus.OK + "</status>" +
                    "</message>";
        }
        return "<message>" +
                "<id>" + id + "</id>" +
                "<status>" + HttpStatus.NOT_FOUND + "</status>" +
                "</message>";
    }
}
