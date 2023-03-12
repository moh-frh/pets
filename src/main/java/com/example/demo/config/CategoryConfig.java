package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;

@Configuration
public class CategoryConfig {
	
	@Bean
	CommandLineRunner commandLineRunnerCategory(CategoryRepository repository) {
		return args -> {
			Category c1 = new Category("category1", "description1");
			Category c2 = new Category("category2", "description2");
			Category c3 = new Category("category3", "description3");
			Category c4 = new Category("category4", "description4");
			Category c5 = new Category("category5", "description5");
			Category c6 = new Category("category6", "description6");
			Category c7 = new Category("category7", "description7");
			
			repository.saveAll(
					List.of(c1, c2, c3, c4, c5, c6, c7)
			);
		};
	}

}
