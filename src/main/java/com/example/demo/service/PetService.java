package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pet;
import com.example.demo.repository.PetRepository;

@Service
public class PetService {
	
	private final PetRepository petRepository;
	
	@Autowired
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	
	public List<Pet> getPets() {
		return petRepository.findAll();
	}

	public void addPets(Pet pet) {
		Optional<Pet> petByName =  petRepository.findPetByName(pet.getName());
		
		if(petByName.isPresent()) {
			throw new IllegalStateException("name taken !!");
		}
		
		petRepository.save(pet);
	}

	public void deletePet(Long petId) {
		Boolean isPetExist = petRepository.existsById(petId);
		
		if(!isPetExist) {
			throw new IllegalStateException("pet with id"+petId+"doesnt exist");
		}
		
		petRepository.deleteById(petId);
		
	}
	
	@Transactional
	public void updatePet(Long petId, String name) {
		Pet pet = petRepository.findById(petId)
				.orElseThrow( () -> new IllegalStateException("pet with id : "+petId+"doesnt exist"));
		
		if(name != null && name.length() > 0 && !Objects.equals(pet.getName(), name)) {
			pet.setName(name);
		}
		
	}

}
