package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping(path = "api/category")
public class CategoryController {
	
private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	} 
	
	@GetMapping
	public List<Category> getCategories() {
//		LOGGER.info("azertyui");
		return categoryService.getCategories();
	}
	
	@PostMapping
	public void registerCategory(@RequestBody Category category) {
		categoryService.addCategories(category);
	}
	
	@DeleteMapping(path = "{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
		categoryService.deleteCategory(categoryId);
	}
	
//	http://localhost:8080/api/category/1?name=ffff
	@PutMapping(path = "{categoryId}")
	public void updateCategory(
			@PathVariable("categoryId") Long categoryId,
			@RequestParam(required = false) String name
			) {
		categoryService.updateCategory(categoryId, name);
	}

}
