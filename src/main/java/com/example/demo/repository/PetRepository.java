package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
	@Query("SELECT p FROM Pet p WHERE p.name = ?1")
	Optional<Pet> findPetByName(String name);
}
