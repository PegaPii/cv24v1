package fr.univrouen.cv24v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplome implements Serializable{

	private static final long serialVersionUID = 1121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long diplome_id;
	@ManyToOne
	@JoinColumn(name="competences_id")
	@XmlTransient
	private Competences competences;

	@Column(name="niveau")
	@XmlAttribute
	private int niveau;

	@ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
	@CollectionTable(name = "titres", joinColumns = @JoinColumn(name = "diplome_id"))
	@Column(name = "titre")
	@XmlElement(required=true)
	private List<String> titre;

	@Column(name = "date")
	@XmlElement(required=true)
	private String date;

	@Column(name = "institut")
	private String institut;

	
	public Diplome() {
		super();
	}
	
	public Long getId() {
		return diplome_id;
	}


	public void setId(Long id) {
		this.diplome_id = id;
	}


	public int getNiveau() {
		return niveau;
	}


	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}


	public List<String> getTitre() {
		return titre;
	}

	public void setTitre(List<String> titre) {
		this.titre = titre;
	}

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getInstitut() {
		return institut;
	}


	public void setInstitut(String institut) {
		this.institut = institut;
	}

	@Override
	public String toString() {
		return "Diplome [id=" + diplome_id + ", identite_id=" + ", niveau=" + niveau + ", titre=" + titre
				+ ", date=" + date + ", institut=" + institut + "]";
	}
	
	
	
}
