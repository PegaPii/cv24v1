package fr.univrouen.cv24v1.utils;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CV24Response {

    @XmlAttribute(required=true)
    private Long id;
    @XmlElement(required=true)
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
