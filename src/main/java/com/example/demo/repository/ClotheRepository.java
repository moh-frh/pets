package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;
import com.example.demo.entity.Clothe;

@Repository
public interface ClotheRepository extends JpaRepository<Clothe, Long>{
	
	//	native query
	//	@Query(
	//			value = "select * from category c where c.category_title = ?1",
	//			nativeQuery = true
	//	)
	
	
	// JPQL
	@Query("SELECT c FROM Clothe c WHERE c.name = ?1")
	Optional<Clothe> findClotheByName(String clothe); 

}
