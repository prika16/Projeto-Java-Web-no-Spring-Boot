package com.devsuperior.projetospring.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.projetospring.entities.Category;
import com.devsuperior.projetospring.repositories.CategoryRepository;

@RestController // para que o rest reconheça minha classe como recurso, coloco essa anotation
@RequestMapping(value = "/categories")

public class CategoryResource {
	
	@Autowired //injeta a dependencia. 
	private CategoryRepository categoryRepository;
	
	@GetMapping // prepara para responder por uma requisição get para o metodo abaixo e  no caminho acima
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list); //".ok" instancia uma resposta dizendo que deu tudo certo. 
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) { //reconhece  "/1" do caminho ex. http://localhost:8080/categories/1}"
		Category cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}

}
