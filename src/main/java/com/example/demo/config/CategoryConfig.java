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
			
			repository.saveAll(
					List.of(c1, c2)
			);
		};
	}

}
