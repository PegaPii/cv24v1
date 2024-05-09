package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Prof implements Serializable{

	private static final long serialVersionUID = 1121L;
	
	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

	@XmlElement(required=true)
	private Detail detail;


	public Prof() {
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



	@Override
	public String toString() {
		return "Prof [id=" + id + ", identite_id=" + identite_id + ", detail=" + detail + "]";
	}
	
	
	
}
