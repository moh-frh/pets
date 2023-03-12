package com.example.demo.config;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Matricule;
import com.example.demo.entity.Pet;
import com.example.demo.repository.MatriculeRepository;
import com.example.demo.repository.PetRepository;

@Configuration
public class MatriculeConfig {
	
	@Bean
	CommandLineRunner commandLineRunnerMatricule(MatriculeRepository repository) {
		return args -> {
			
//			Pet p = new Pet("petX", "descriptionX", "codeX");
//			
//			Matricule m1 = new Matricule("code1", p);
//			
//			repository.saveAll(
//					List.of(m1)
//			);
		};
	}

}
