package fr.univrouen.cv24v1.controllers;

import fr.univrouen.cv24v1.repository.CV24ResponseRepository;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.service.CVService;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cv24")
public class DeleteController {

    @Autowired
    private cv24Repository cvRepository;
    @Autowired
    private CV24ResponseRepository responseRepository;
    @Autowired
    private CVService cvService;

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam(value = "id") int id) throws JAXBException {
        CV24Response response = new CV24Response();
        if(cvRepository.existsById((long) id)) {
            cvRepository.deleteById((long) id);
            response.setStatus("DELETED");
            responseRepository.save(response);
            return ResponseEntity.status(HttpStatus.OK).body(cvService.responseToXml(response));
        }
        response.setStatus("ERROR");
        responseRepository.save(response);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(cvService.responseToXml(response));

    }
}
