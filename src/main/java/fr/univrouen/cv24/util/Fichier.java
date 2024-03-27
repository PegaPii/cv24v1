package fr.univrouen.cv24.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

public class Fichier {
	private Resource resource;
	
	public Fichier() {
		this.resource = new DefaultResourceLoader().getResource("smallCV.xml");
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
