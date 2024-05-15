package fr.univrouen.cv24v1.model;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "cv24s")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListCV24 implements Serializable{
    @XmlElement(name = "cv24")
    private List<cv24> cv24;

    public ListCV24() {
        super();
    }

    public List<cv24> getCv24() {
        return cv24;
    }

    public void setCv24(List<cv24> cv24) {
        this.cv24 = cv24;
    }
}
