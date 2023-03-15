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

import com.example.demo.entity.Clothe;
import com.example.demo.service.ClotheService;

@RestController
@RequestMapping(path = "api/clothe")
public class ClotheController {
	
	private final ClotheService clotheService;
	
	@Autowired
	public ClotheController(ClotheService clotheService) {
		this.clotheService = clotheService;
	} 
	
	@GetMapping
	public List<Clothe> getClothes() {
//		LOGGER.info("azertyui");
		return clotheService.getClothes();
	}
	
	@PostMapping
	public Object registerClothe(@RequestBody Clothe clothe) {
		System.out.println("::cloth-controoler::"+clothe);
		return clotheService.addClothes(clothe);
	}
	
	@DeleteMapping(path = "{clotheId}")
	public void deleteClothe(@PathVariable("clotheId") Long clotheId) {
		clotheService.deleteClothe(clotheId);
	}
	
//	http://localhost:8080/api/clothe/1?name=ffff
	@PutMapping(path = "{clotheId}")
	public void updateClothe(
			@PathVariable("clotheId") Long clotheId,
			@RequestParam(required = false) String name
			) {
		clotheService.updateClothe(clotheId, name);
	}

}
