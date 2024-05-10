package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@XmlAccessorType(XmlAccessType.FIELD)
public class Certif implements Serializable{

	private static final long serialVersionUID = 1121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

	@Column(name="datedeb")
	@XmlElement(required=true)
	private String datedeb;
	@Column(name="datefin")
	private String datefin;

	@Column(name="titre")
	@XmlElement(required=true)
	private String titre;


	
	public Certif() {
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


	public String getDatedeb() {
		return datedeb;
	}


	public void setDatedeb(String datedeb) {
		this.datedeb = datedeb;
	}


	public String getDatefin() {
		return datefin;
	}


	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Certif [id=" + id + ", identite_id=" + identite_id + ", datedeb=" + datedeb + ", datefin=" + datefin
				+ ", titre=" + titre + "]";
	}


	
}
