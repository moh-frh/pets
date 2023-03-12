package com.example.demo.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	
//	JPQL
//	@Query("SELECT p FROM Pet p WHERE p.name = ?1")
//	Optional<Pet> findPetByName(String name);
	
//	Native
//	@Query(
//			value = "SELECT * FROM pet p WHERE p.name = ?1",
//			nativeQuery = true
//	)
	
//	Native Named Param
	@Query(
			value = "SELECT * FROM pet p WHERE p.name = :pet_name",
			nativeQuery = true
	)
	Optional<Pet> findPetByName(@Param("pet_name") String name);
	
//	@Modifying 
//	@Transactional
//	@Query(value = "UPDATE pet set description = ?1 where name = ?2", nativeQuery = true)
//	int updatePetDescriptionByName(String name, String description);
	
}
