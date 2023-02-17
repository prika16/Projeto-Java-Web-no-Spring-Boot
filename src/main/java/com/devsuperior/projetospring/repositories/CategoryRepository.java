package com.devsuperior.projetospring.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.projetospring.entities.Category;

@Component
public class CategoryRepository {
	
	private Map<Long, Category> map = new HashMap<>();
	
	public void save(Category obj) {
		map.put(obj.getId(), obj);
	}

	public Category findById(Long id) { //método que retorna a categoria do id informado
		return map.get(id); //pesquisar no map se tem a categoria com id informado
	}
	
	public List<Category> findAll() {
		return new ArrayList<Category>(map.values());//Pega todos os valores e retorna uma nova lista com todos os valores.
		
	}

}
