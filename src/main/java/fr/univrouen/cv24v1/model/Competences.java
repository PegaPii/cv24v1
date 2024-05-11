package fr.univrouen.cv24v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Competences implements Serializable{

	private static final long serialVersionUID = 1121L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long competences_id;


	@OneToMany(mappedBy="competences", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@XmlElement(required=true)
	private List<Diplome> diplome;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "certif_id")
	@XmlElement
	private List<Certif> certif;


	
	public Competences() {
		super();
	}
	
	public Long getId() {
		return competences_id;
	}

	public void setId(Long id) {
		this.competences_id = id;
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
		return "Competences [id=" + competences_id + ", identite_id=" + ", diplome=" + diplome + ", certif=" + certif
				+ "]";
	}
	
}
