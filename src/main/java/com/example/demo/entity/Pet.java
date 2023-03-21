package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(
		name = "pet",
		uniqueConstraints = @UniqueConstraint(
								name="code_id_unique",
								columnNames = "code_column"
							)
)

public class Pet {
	@Id
	@SequenceGenerator(name = "pet_sequence", sequenceName = "pet_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pet_sequence")
	private Long id;
//	@Column(name = "name_in_table")
	private String name;
	private String description;
	
	@Column(name = "code_column", nullable = false)
	private String code;
	
	
	@OneToOne(mappedBy = "pet", cascade = CascadeType.ALL)
	private Matricule matricule;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(
			name = "category_id",
			referencedColumnName = "id"
	)
	private Category category;
	
//	@Column(name = "category_id") // specify the column name in the database
//    private Long categoryId;
	
	
	public Pet(String name, String description, String code, Long categoryId) {
		this.name = name;
		this.description = description;
		this.code = code;
//		this.categoryId = categoryId;
	}
	
}
