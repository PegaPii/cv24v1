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
public class Prof implements Serializable{

	private static final long serialVersionUID = 1121L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long id;

	@OneToMany(mappedBy = "prof",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@XmlElement(required=true)
	private List<Detail> detail;


	public Prof() {
		super();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public List<Detail> getDetail() {
		return detail;
	}

	public void setDetail(List<Detail> detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "Prof [id=" + id + ", identite_id=" + ", detail=" + detail + "]";
	}
	
	
	
}
