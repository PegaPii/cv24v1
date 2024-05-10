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
public class Prof implements Serializable{

	private static final long serialVersionUID = 1121L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private int id;

	@XmlTransient
	private int identite_id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@XmlElement(required=true)
	private List<Detail> detail;


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

	public List<Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<Detail> detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "Prof [id=" + id + ", identite_id=" + identite_id + ", detail=" + detail + "]";
	}
	
	
	
}
