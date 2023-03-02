package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Pet;
import com.example.demo.service.PetService;

@RestController
@RequestMapping(path = "api/pet")
public class PetController {
	private final PetService petService;
	
	@Autowired
	public PetController(PetService petService) {
		this.petService = petService;
	}
	
	@GetMapping
	public List<Pet> getPets() {
//		LOGGER.info("azertyui");
		return petService.getPets();
	}
	
	@PostMapping
	public void registerPet(@RequestBody Pet pet) {
		petService.addPets(pet);
	}
	
	@DeleteMapping(path = "{petId}")
	public void deletePet(@PathVariable("petId") Long petId) {
		petService.deletePet(petId);
	}
	
//	http://localhost:8080/api/pet/1?name=ffff
	@PutMapping(path = "{petId}")
	public void updatePet(
			@PathVariable("petId") Long petId,
			@RequestParam(required = false) String name
			) {
		petService.updatePet(petId, name);
	}

}
