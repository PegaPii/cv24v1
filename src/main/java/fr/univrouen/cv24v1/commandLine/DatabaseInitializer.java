package fr.univrouen.cv24v1.commandLine;

import fr.univrouen.cv24v1.model.cv24;
import fr.univrouen.cv24v1.repository.cv24Repository;
import fr.univrouen.cv24v1.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    @Autowired
    private cv24Repository cv24Repository;

    @Autowired
    private CVService cvService;
    @Override
    public void run(String... args) throws Exception {
        File file = new File(getClass().getResource("/xml/exemple_simple.xml").getFile());
        String xml = new String(Files.readAllBytes(file.toPath()));
        cv24 cv = cvService.stringToCv(xml);
        cv.debug();
        File file2 = new File(getClass().getResource("/xml/example_complexe.xml").getFile());
        String xml2 = new String(Files.readAllBytes(file2.toPath()));
        cv24 cv2 = cvService.stringToCv(xml2);
        cv2.debug();
        cv24Repository.save(cv);
        cv24Repository.save(cv2);
    }
}