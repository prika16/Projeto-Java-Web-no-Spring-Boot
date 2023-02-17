package com.devsuperior.projetospring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.projetospring.entities.Category;
import com.devsuperior.projetospring.entities.Product;
import com.devsuperior.projetospring.repositories.CategoryRepository;
import com.devsuperior.projetospring.repositories.ProductRepository;

@RestController // para que o rest reconheça minha classe como recurso, coloco essa anotation
@RequestMapping(value = "/products")

public class ProductResource {
	
	@Autowired //injeta a dependencia. 
	private ProductRepository categoryRepository;
	
	@GetMapping // prepara para responder por uma requisição get para o metodo abaixo e  no caminho acima
	public ResponseEntity<List<Product>> findAll() {
		List<Product> list = categoryRepository.findAll();
		return ResponseEntity.ok().body(list); //".ok" instancia uma resposta dizendo que deu tudo certo. 
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) { //reconhece  "/1" do caminho ex. http://localhost:8080/categories/1}"
		Product cat = categoryRepository.findById(id);
		return ResponseEntity.ok().body(cat);
	}

}
