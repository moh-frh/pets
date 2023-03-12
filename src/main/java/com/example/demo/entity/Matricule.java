package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

// this used to exclude pet from Matricule
//@ToString(exclude = "pet")

public class Matricule {
	@Id
	@SequenceGenerator(name = "matricule_sequence", sequenceName = "matricule_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "matricule_sequence")
	private Long id;
	
	private String code;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_id", referencedColumnName = "id")
	private Pet pet;
	
	public Matricule(String code, Pet pet) {
		this.code = code;
		this.pet = pet;
		
	}
}
