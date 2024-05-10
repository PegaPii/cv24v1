package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Autre implements Serializable{

	private static final long serialVersionUID = 1121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long id;

	@XmlTransient
	private int identite_id;

	@Column(name="comment")
	@XmlAttribute
	private String comment;

	@Column(name="titre")
	@XmlAttribute(required=true)
	private String titre;

	
	public Autre() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIdentite_id() {
		return identite_id;
	}

	public void setIdentite_id(int identite_id) {
		this.identite_id = identite_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Autres [id=" + id + ", identite_id=" + identite_id + ", comment=" + comment + ", titre=" + titre + "]";
	}
	
	
	



	
	
	
	
}
