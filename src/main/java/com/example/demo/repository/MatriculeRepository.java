package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Matricule;

public interface MatriculeRepository extends JpaRepository<Matricule, Long>{
//	native query
//	@Query(
//			value = "select * from category c where c.category_title = ?1",
//			nativeQuery = true
//	)
	
	
	// JPQL
	@Query("SELECT m FROM Matricule m WHERE m.code = ?1")
	Optional<Matricule> findMatriculeByName(String code); 
}
