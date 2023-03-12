package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Matricule;
import com.example.demo.repository.MatriculeRepository;

@Service
public class MatriculeService {
	

	private final MatriculeRepository matriculeRepository;
	
	@Autowired
	public MatriculeService(MatriculeRepository matriculeRepository) {
		this.matriculeRepository = matriculeRepository;
	}
	
	
	
	
	public List<Matricule> getMatricules() {
		return matriculeRepository.findAll();
	}

	public void addMatricules(Matricule matricule) {
		Optional<Matricule> matriculeByName =  matriculeRepository.findMatriculeByName(matricule.getCode());
		
		if(matriculeByName.isPresent()) {
			throw new IllegalStateException("code taken !!");
		}
		
		matriculeRepository.save(matricule);
	}

	public void deleteMatricule(Long matriculeId) {
		Boolean isMatriculeExist = matriculeRepository.existsById(matriculeId);
		
		if(!isMatriculeExist) {
			throw new IllegalStateException("matricule with id"+matriculeId+"doesnt exist");
		}
		
		matriculeRepository.deleteById(matriculeId);
		
	}
	
	@Transactional
	public void updateMatricule(Long matriculeId, String code) {
		Matricule matricule = matriculeRepository.findById(matriculeId)
				.orElseThrow( () -> new IllegalStateException("matricule with id : "+matriculeId+"doesnt exist"));
		
		if(code != null && code.length() > 0 && !Objects.equals(matricule.getCode(), code)) {
			matricule.setCode(code);
		}
		
	}

}
