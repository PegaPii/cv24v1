package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlValue;

@Table
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Objectif implements Serializable{

	private static final long serialVersionUID = 1121L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long objectif_id;

	@Column(name="statut")
	@XmlAttribute(required=true)
	private String statut;
	@Column(name="objectif")
	@XmlValue
	private String objectif;
	
	public Objectif() {
		super();
	}
	
	public Long getId() {
		return objectif_id;
	}

	public void setId(Long id) {
		this.objectif_id = id;
	}
	
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	@Override
	public String toString() {
		return "Objectif [id=" + objectif_id + ", identite_id=" + ", statut=" + statut + ", objectif=" + objectif
				+ "]";
	}

	
}
