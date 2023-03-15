package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Matricule;
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
	public void updatePet(Long petId, Pet new_pet) {
		Pet pet = petRepository.findById(petId)
				.orElseThrow( () -> new IllegalStateException("pet with id : "+petId+"doesnt exist"));
		
		System.out.println("pet : "+new_pet);
		
		if(new_pet.getName() != null && new_pet.getName().length() > 0 && !Objects.equals(pet.getName(), new_pet.getName())) {
			pet.setName(new_pet.getName());
			pet.setDescription(new_pet.getDescription());
			pet.setCode(new_pet.getCode());
			
			pet.setMatricule(new Matricule("code mat", pet));
			
		}
		System.out.println("else : ");
		
	}

}
