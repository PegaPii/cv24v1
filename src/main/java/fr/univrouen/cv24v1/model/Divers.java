package fr.univrouen.cv24v1.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@Table
@XmlAccessorType(XmlAccessType.FIELD)
public class Divers implements Serializable{

	private static final long serialVersionUID = 1121L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@XmlElement(required=true)
	private List<Lv> lv;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@XmlElement(name="autre")
	private List<Autre> autre;


	
	public Divers() {
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


	public List<Lv> getLv() {
		return lv;
	}


	public void setLv(List<Lv> lv) {
		this.lv = lv;
	}


	public List<Autre> getAutre() {
		return autre;
	}


	public void setAutre(List<Autre> autre) {
		this.autre = autre;
	}

	@Override
	public String toString() {
		return "Divers [id=" + id + ", identite_id=" + identite_id + ", lv=" + lv + ", autre=" + autre + "]";
	}
	
}
