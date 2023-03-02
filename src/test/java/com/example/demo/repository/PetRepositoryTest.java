package com.example.demo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Pet;

@SpringBootTest
@DataJpaTest

class PetRepositoryTest {
	
	@Autowired
	private PetRepository petRepository;

	@Test
	public void testSavePets() {
		Pet pet = Pet.builder()
				.name("pet name test")
				.description("pet desc test")
				.build();
		
		petRepository.save(pet);
	}

}
