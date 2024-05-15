package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@Entity
@XmlRootElement(name = "cv24")
@XmlAccessorType(XmlAccessType.FIELD)
public class cv24 implements Serializable {
	private static final long serialVersionUID = 2024L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "identite_id")
	@XmlElement(required=true)
	private Identite identite;


	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "objectif_id")
	@XmlElement(required=true)
	private Objectif objectif;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "prof_id")
	private Prof prof;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "competences_id")
	@XmlElement(required=true)
	private Competences competences;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	@JoinColumn(name = "divers_id")
	private Divers divers;
	
	public cv24() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		System.out.println(toString());
	}


}
