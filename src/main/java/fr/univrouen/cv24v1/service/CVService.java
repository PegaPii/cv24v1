package fr.univrouen.cv24v1.service;

import fr.univrouen.cv24v1.model.cv24;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

@Service
public class CVService {
    public cv24 stringToCv(String str) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(cv24.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(str);
        cv24 cv = (cv24) unmarshaller.unmarshal(reader);
        return cv;
    }

    public boolean validateXML(String str) throws IOException, SAXException {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(new ClassPathResource("tp_resources/cv24.tp1.xsd").getInputStream()));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new StringReader(str)));
        }
        catch (SAXException e){
            return false;
        }
        return true;
    }

}
