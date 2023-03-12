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

import com.example.demo.entity.Matricule;
import com.example.demo.service.MatriculeService;

@RestController
@RequestMapping(path = "api/matricule")
public class MatriculeController {
	

	
private final MatriculeService matriculeService;
	
	@Autowired
	public MatriculeController(MatriculeService matriculeService) {
		this.matriculeService = matriculeService;
	} 
	
	@GetMapping
	public List<Matricule> getMatricules() {
//		LOGGER.info("azertyui");
		return matriculeService.getMatricules();
	}
	
	@PostMapping
	public void registerMatricule(@RequestBody Matricule matricule) {
		matriculeService.addMatricules(matricule);
	}
	
	@DeleteMapping(path = "{matriculeId}")
	public void deleteMatricule(@PathVariable("matriculeId") Long matriculeId) {
		matriculeService.deleteMatricule(matriculeId);
	}
	
//	http://localhost:8080/api/matricule/1?name=ffff
	@PutMapping(path = "{matriculeId}")
	public void updateMatricule(
			@PathVariable("matriculeId") Long matriculeId,
			@RequestParam(required = false) String code
			) {
		matriculeService.updateMatricule(matriculeId, code);
	}

}
