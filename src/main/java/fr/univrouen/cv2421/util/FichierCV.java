package fr.univrouen.cv2421.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class FichierCV {
private Resource resource;
	
	public FichierCV() {
		this.resource = new DefaultResourceLoader().getResource("tp1.good2.xml");
	}
	
	public String loadFileXML() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            return "Erreur lors de la lecture du fichier : " + e.getMessage();
        }
        return content.toString();
    }
}
