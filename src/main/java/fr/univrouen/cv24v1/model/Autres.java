package fr.univrouen.cv24v1.model;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Autres implements Serializable{

	private static final long serialVersionUID = 1121L;

	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

	@XmlAttribute
	private String comment;
	
	@XmlAttribute(required=true)
	private String titre;

	
	public Autres() {
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
