package fr.univrouen.cv24v1.model;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class TestCV   {
	public static void main(String[] args) {
        try {

            // Normal JAXB RI
            //jaxbContext = JAXBContext.newInstance(Fruit.class);

            // EclipseLink MOXy needs jaxb.properties at the same package with Fruit.class
            // Alternative, I prefer define this via eclipse JAXBContextFactory manually.


            JAXBContext jaxbContext = JAXBContext.newInstance(CV.class);

            File file = new File("src\\main\\resources\\tp_resources\\tp1.good2.xml");

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            CV cv = (CV) jaxbUnmarshaller.unmarshal(file);

            cv.debug();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
