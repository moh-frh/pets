package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Clothe {
	
	@Id
	@SequenceGenerator(name = "clothe_sequence", sequenceName = "clothe_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clothe_sequence")
	private Long clothId;
	
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "pet_clothe_map",
			joinColumns = @JoinColumn(
					name = "cloth_id",
					referencedColumnName = "clothId"
			),
			inverseJoinColumns = @JoinColumn(
					name = "pet_id",
					// id: is id of pet table
					referencedColumnName = "id"
			)
			
			
	)
	private List<Pet> pets;
}
