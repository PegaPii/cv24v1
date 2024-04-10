package fr.univrouen.cv24.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlElement;


public class Identite implements Serializable{

	private static final long serialVersionUID = 1121L;

	@XmlElement
	private String nom;

	@XmlElement
	private String prenom;

	
	
	public Identite() {
		super();
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
