package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Clothe;
import com.example.demo.repository.ClotheRepository;

@Service
public class ClotheService {
	private final ClotheRepository clotheRepository;
	
	@Autowired
	public ClotheService(ClotheRepository clotheRepository) {
		this.clotheRepository = clotheRepository;
	}
	
	
	public List<Clothe> getClothes() {
		return clotheRepository.findAll();
	}

	public Clothe addClothes(Clothe clothe) {
		Optional<Clothe> clotheByName =  clotheRepository.findClotheByName(clothe.getName());
		
		if(clotheByName.isPresent()) {
			throw new IllegalStateException("name taken !!");
		}
		
		return clotheRepository.save(clothe);
	}

	public void deleteClothe(Long clotheId) {
		Boolean isClotheExist = clotheRepository.existsById(clotheId);
		
		if(!isClotheExist) {
			throw new IllegalStateException("clothe with id"+clotheId+"doesnt exist");
		}
		
		clotheRepository.deleteById(clotheId);
		
	}
	
	@Transactional
	public void updateClothe(Long clotheId, String name) {
		Clothe clothe = clotheRepository.findById(clotheId)
				.orElseThrow( () -> new IllegalStateException("clothe with id : "+clotheId+"doesnt exist"));
		
		if(name != null && name.length() > 0 && !Objects.equals(clothe.getName(), name)) {
			clothe.setName(name);
		}
		
	}
}
