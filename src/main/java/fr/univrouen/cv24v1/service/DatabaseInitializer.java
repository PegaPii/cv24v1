package fr.univrouen.cv24v1.service;

import fr.univrouen.cv24v1.model.cv24;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private cv24Repository cv24Repository;

    @Autowired
    private  CVService cvService;
    @Override
    public void run(String... args) throws Exception {
        File file = new File(getClass().getResource("/tp_resources/tp1.good2.xml").getFile());
        String xml = new String(Files.readAllBytes(file.toPath()));
        cv24 cv = cvService.stringToCv(xml);
        File file2 = new File(getClass().getResource("/tp_resources/example2.xml").getFile());
        String xml2 = new String(Files.readAllBytes(file2.toPath()));
        cv24 cv2 = cvService.stringToCv(xml2);

        cv24Repository.save(cv);
        cv24Repository.save(cv2);
    }
}