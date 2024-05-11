package fr.univrouen.cv24v1.model;

import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Cache;

@Table
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
public class Detail implements Serializable{

	private static final long serialVersionUID = 1121L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@XmlTransient
	private Long detail_id;

	@ManyToOne
	@JoinColumn(name="prof_id")
	@XmlTransient
	private Prof prof;


	@Column(name = "titre")
	@XmlElement(required=true)
	private String titre;

	@Column(name = "datedeb")
	@XmlElement(required=true)
	private String datedeb;

	@Column(name = "datefin")
	private String datefin;


	
	public Detail() {
		super();
	}



	public Long getId() {
		return detail_id;
	}



	public void setId(Long id) {
		this.detail_id = id;
	}



	public String getTitre() {
		return titre;
	}



	public void setTitre(String titre) {
		this.titre = titre;
	}



	public String getDatedeb() {
		return datedeb;
	}



	public void setDatedeb(String datedeb) {
		this.datedeb = datedeb;
	}



	public String getDatefin() {
		return datefin;
	}



	public void setDatefin(String datefin) {
		this.datefin = datefin;
	}



	@Override
	public String toString() {
		return "Detail [id=" + detail_id + ", identite_id=" + ", titre=" + titre + ", datedeb=" + datedeb
				+ ", datefin=" + datefin + "]";
	}

	
	
}
