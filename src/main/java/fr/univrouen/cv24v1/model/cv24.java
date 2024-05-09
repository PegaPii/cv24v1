package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;


@XmlRootElement(name = "cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class cv24 implements Serializable {
	private static final long serialVersionUID = 2024L;
	private static int compteur = 1;

	@XmlTransient
	private Integer id;

	@XmlElement(required=true)
	private Identite identite;
	

	@XmlElement(required=true)
	private Objectif objectif;

	private Prof prof;

	@XmlElement(required=true)
	private Competences competences;
	
	private Divers divers;
	
	public cv24() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Identite getIdentite() {
		return identite;
	}
	
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public Objectif getObjectif() {
		return objectif;
	}

	public void setObjectif(Objectif objectif) {
		this.objectif = objectif;
	}

	public Prof getProf() {
		return prof;
	}

	public void setProf(Prof prof) {
		this.prof = prof;
	}

	public Competences getCompetences() {
		return competences;
	}

	public void setCompetences(Competences competences) {
		this.competences = competences;
	}

	public Divers getDivers() {
		return divers;
	}

	public void setDivers(Divers divers) {
		this.divers = divers;
	}
	
	
	
	@Override
	public String toString() {
		return "cv24 [id=" + id + ", identite=" + identite + ", objectif=" + objectif + ", prof=" + prof
				+ ", competences=" + competences + ", divers=" + divers + "]";
	}

	public void debug() {
		System.out.println(identite.toString()+" \n");
		System.out.println(toString());
	}
	

}
