package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Pet;
import com.example.demo.repository.PetRepository;

@Configuration
public class PetConfig {
	@Bean
	CommandLineRunner commandLineRunnerPet(PetRepository repository) {
		return args -> {
			Pet p1 = new Pet("pet1", "description1", "code1");
			Pet p2 = new Pet("pet2", "description2", "code2");
			
			repository.saveAll(
					List.of(p1, p2)
			);
		};
	}

}
