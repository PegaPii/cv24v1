package fr.univrouen.cv24v1.model;

import jakarta.persistence.*;

@Entity
@Table(name="test")
public class testDB {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name = "caca")
	private String caca = "caca";

}
