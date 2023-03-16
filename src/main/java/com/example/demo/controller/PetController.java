package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Pet;
import com.example.demo.exception.PetNotFoundException;
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
		List<Pet> pets = petService.getPets();
		
		if(pets.size() == 0) {
			throw new PetNotFoundException("Pets is empty");
		}
		
		return pets;
		
		
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
			@RequestBody(required = false) Pet pet
			) {
		System.out.println("::controller:: name : "+pet.getName());
		petService.updatePet(petId, pet);
	}

}
