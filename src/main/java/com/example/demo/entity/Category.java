package com.example.demo.entity;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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
@AttributeOverrides({
	@AttributeOverride(
			name = "title",
			column = @Column(name = "category_title")
	),
	@AttributeOverride(
			name = "description",
			column = @Column(name = "category_description")
	)
})
public class Category {
	
	@Id
	@SequenceGenerator(name = "category_sequence", sequenceName = "category_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
	private Long id;
	private String title;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//	, fetch = FetchType.LAZY
	// referencedColumnName is id of category table
	@JsonIgnore
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private List<Pet> pets;
	
	
	public Category(String title, String description) {
		this.title = title;
		this.description = description;
		
	}

}
