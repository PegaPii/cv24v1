package fr.univrouen.cv24v1.utils;

import jakarta.xml.bind.annotation.*;
import jakarta.persistence.*;

import java.util.Date;


@Table
@Entity
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.FIELD)
public class CV24Response {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private Long responseId;
    @XmlAttribute(required=true)
    private Long id;
    @Column(name="status")
    @XmlElement(required=true)
    private String status;

    @Column(name="detail")
    private String detail;

    @XmlTransient
    @Column(name = "date", updatable = false)
    private Date date;

    public CV24Response(){
        date = new Date();
    }
    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
