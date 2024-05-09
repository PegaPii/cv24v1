package fr.univrouen.cv24v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Competences implements Serializable{

	private static final long serialVersionUID = 1121L;

	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;
	
	@XmlElement(required=true)
	private List<Diplome> diplome;

	@XmlElement
	private List<Certif> certif;


	
	public Competences() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdentiteId() {
		return this.identite_id;
	}

	public void setIdentiteId(int identite_id) {
		this.identite_id = identite_id;
	}
	
	public List<Diplome> getDiplome() {
		return this.diplome;
	}

	public void setDiplome(List<Diplome> diplomes) {
		this.diplome = diplomes;
	}
	
	public List<Certif> getCertif() {
		return certif;
	}

	public void setCertif(List<Certif> certif) {
		this.certif = certif;
	}

	@Override
	public String toString() {
		return "Competences [id=" + id + ", identite_id=" + identite_id + ", diplome=" + diplome + ", certif=" + certif
				+ "]";
	}
	
}
