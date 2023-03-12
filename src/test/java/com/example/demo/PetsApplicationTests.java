package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.example.demo.entity.Category;
import com.example.demo.entity.Matricule;
import com.example.demo.entity.Pet;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.MatriculeRepository;
import com.example.demo.repository.PetRepository;

@SpringBootTest
class PetsApplicationTests {
	
	@Autowired
	private PetRepository petRepository;
	
	@Autowired
	private MatriculeRepository matriculeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void getCategoriesBy() {
		System.out.println("getPetsAfterInsertingTest +++++++++++++++++++++++++++++++++++++++++++++++++");
		
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		
		List<Category> categories = categoryRepository.findAll();
		
		System.out.println(categories.toString()+ "+++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	
//error !!!!!!!
	@Test
	public void savePetsTest() {
		System.out.println("savePetsTest --------------------------------------------------");
		Pet pet = Pet.builder()
				.name("pet name test")
				.description("pet desc test")
				.code("pet code test")
				.build();
		
		System.out.println("2 !!!");
		
		petRepository.save(pet); 
		
		System.out.println("-----------------------------------------------------------");
	}
	
	@Test
	public void getAllPetsTest() {
		System.out.println("getAllPetsTest --------------------------------------------------");
		
		
		List<Pet> pets = petRepository.findAll(); 
		
		System.out.println(pets);
		
		System.out.println("-----------------------------------------------------------");
	}
	
	@Test
	public void getPetByIdTest() {
		System.out.println("getPetByIdTest --------------------------------------------------");
		
		
		Optional<Pet> pet = petRepository.findPetByName("pet1"); 
		
		System.out.println(pet);
		
		System.out.println("//getPetByIdTest-----------------------------------------------------------");
	}
	
	@Test
	public void saveMatriculeTest() {
		System.out.println("saveMatriculeTest --------------------------------------------------");
		
//		Pet pet = Pet.builder()
//				.name("pet mat")
//				.description("desc mat")
//				.code("code mat")
//				.build();
//		
//		Matricule matricule = Matricule.builder()
//				.code("code matricule ***")
//				.pet(pet)
//				.build();
//		
//		matriculeRepository.save(matricule); 
//		System.out.println(matricule+"--//saveMatriculeTest-----------------------------------------------------------");
	}
	
	@Test
	public void getPetsAfterInsertingTest() {
		System.out.println("getPetsAfterInsertingTest --------------------------------------------------");
		
		List<Pet> pets = petRepository.findAll();
		
		System.out.println("getPetsAfterInsertingTest : "+pets+"-------------------------------------------------------------");
	}
	
	@Test
	public void saveCategoryTest() {
		System.out.println("saveCategoryTest --------------------------------------------------");
		
//		Pet pet1 = Pet.builder()
//				.name("pet cat 1")
//				.description("desc cat 1")
//				.code("code cat 1")
//				.build();
//		
//		Pet pet2 = Pet.builder()
//				.name("pet cat 2")
//				.description("desc cat 2")
//				.code("code cat 2")
//				.build();
//		
//		Category category = Category.builder()
//				.description("desc category")
//				.title("title category")
//				.pets(List.of(pet1, pet2))
//				.build();
//		
//		categoryRepository.save(category); 
//		System.out.println(category+"--//saveCategoryTest-----------------------------------------------------------");
	}
	
	
	
//	@Test
//	public void updatePetDescriptionByName() {
//		System.out.println("updatePetDescriptionByName --------------------------------------------------");
//		
//		 
//		int tmp = petRepository.updatePetDescriptionByName("pet1", "****"); 
//		
//		System.out.println(tmp);
//		
//		System.out.println("//updatePetDescriptionByName-----------------------------------------------------------");
//	}
	
	
	
	

}
