package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Identite implements Serializable{

	private static final long serialVersionUID = 1121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long identite_id;

	@Column(name="genre")
	private String genre;


	@Column(name="nom")
	@XmlElement(required=true)
	private String nom;

	@Column(name="prenom")
	@XmlElement(required=true)
	private String prenom;

	@Column(name="tel")
	private String tel;

	@Column(name="mel")
	private String mel;
	
	public Identite() {
		super();
	}
	
	public Long getId() {
		return identite_id;
	}

	public void setId(Long id) {
		this.identite_id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
	

	public String getMel() {
		return mel;
	}

	public void setMel(String mel) {
		this.mel = mel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "Identite [id=" + identite_id + ", genre=" + genre + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel
				+ ", mel=" + mel + "]";
	}


	
	
}
