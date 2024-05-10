package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@XmlAccessorType(XmlAccessType.NONE)
public class Lv implements Serializable{

	private static final long serialVersionUID = 1121L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

	@Column(name="lang")
	@XmlAttribute(required=true)
	private String lang;

	@Column(name="cert")
	@XmlAttribute(required=true)
	private String cert;
	@Column(name="nivs")
	@XmlAttribute
	private String nivs;
	@Column(name="nivi")
	@XmlAttribute
	private String nivi;
	


	
	public Lv() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdentite_id() {
		return identite_id;
	}


	public void setIdentite_id(int identite_id) {
		this.identite_id = identite_id;
	}
	
	public String getLang() {
		return lang;
	}


	public void setLang(String lang) {
		this.lang = lang;
	}


	public String getCert() {
		return cert;
	}


	public void setCert(String cert) {
		this.cert = cert;
	}


	public String getNivs() {
		return nivs;
	}


	public void setNivs(String nivs) {
		this.nivs = nivs;
	}


	public String getNivi() {
		return nivi;
	}


	public void setNivi(String nivi) {
		this.nivi = nivi;
	}


	@Override
	public String toString() {
		return "Lv [id=" + id + ", identite_id=" + identite_id + ", lang=" + lang + ", cert=" + cert + ", nivs=" + nivs
				+ ", nivi=" + nivi + "]";
	}
	
	
	
	
}
