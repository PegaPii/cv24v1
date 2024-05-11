package fr.univrouen.cv24v1.service;

import fr.univrouen.cv24v1.model.cv24;
import fr.univrouen.cv24v1.utils.CV24Response;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
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
import java.io.StringWriter;

@Service
public class CVService {
    public cv24 stringToCv(String str) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(cv24.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(str);
        cv24 cv = (cv24) unmarshaller.unmarshal(reader);
        return cv;
    }

    public String responseToXml(CV24Response response) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(CV24Response.class);
        // Créer un Marshaller à partir du JAXBContext
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // Marshaller l'objet Java en flux XML
        StringWriter writer = new StringWriter();
        marshaller.marshal(response, writer);
        return writer.toString();

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
