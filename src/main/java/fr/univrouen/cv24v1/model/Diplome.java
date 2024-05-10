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
@XmlAccessorType(XmlAccessType.FIELD)
public class Diplome implements Serializable{

	private static final long serialVersionUID = 1121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

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
		return "Diplome [id=" + id + ", identite_id=" + identite_id + ", niveau=" + niveau + ", titre=" + titre
				+ ", date=" + date + ", institut=" + institut + "]";
	}
	
	
	
}
