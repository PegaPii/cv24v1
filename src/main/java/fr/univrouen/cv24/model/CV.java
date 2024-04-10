package fr.univrouen.cv24.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CV")
@XmlAccessorType(XmlAccessType.NONE)
public class CV implements Serializable {
	private static final long serialVersionUID = 2024L;
	private static int compteur = 1;
	
	@XmlElement
	private Identite identite;
	
	@XmlAttribute
	private Integer id;
	
	@XmlElement
	private String date;
	
	@XmlElement
	private String mel;
	
	public CV(String nom, String prenom, String date, String mel) {
		super();
		identite = new Identite();
		this.id = compteur++;
		this.identite.setNom(nom);
		this.identite.setPrenom(prenom);
		this.date = date;
		this.mel = mel;
	}
	
	public CV() {
		
	}
	
	@Override
	public String toString() {
		return ("CV (" + id + ") [" +identite.getNom() + " " + identite.getPrenom() + ", Date nais = " + date + ", mel = " + mel);
	}
}
