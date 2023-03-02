package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	
	
	
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	public void addCategories(Category category) {
		Optional<Category> categoryByName =  categoryRepository.findCategoryByName(category.getTitle());
		
		if(categoryByName.isPresent()) {
			throw new IllegalStateException("title taken !!");
		}
		
		categoryRepository.save(category);
	}

	public void deleteCategory(Long categoryId) {
		Boolean isCategoryExist = categoryRepository.existsById(categoryId);
		
		if(!isCategoryExist) {
			throw new IllegalStateException("category with id"+categoryId+"doesnt exist");
		}
		
		categoryRepository.deleteById(categoryId);
		
	}
	
	@Transactional
	public void updateCategory(Long categoryId, String title) {
		Category category = categoryRepository.findById(categoryId)
				.orElseThrow( () -> new IllegalStateException("category with id : "+categoryId+"doesnt exist"));
		
		if(title != null && title.length() > 0 && !Objects.equals(category.getTitle(), title)) {
			category.setTitle(title);
		}
		
	}
}
