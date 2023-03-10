package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
//	native query
//	@Query(
//			value = "select * from category c where c.category_title = ?1",
//			nativeQuery = true
//	)
	
	
	// JPQL
	@Query("SELECT c FROM Category c WHERE c.title = ?1")
	Optional<Category> findCategoryByName(String title); 

}
