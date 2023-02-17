package com.devsuperior.projetospring.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.devsuperior.projetospring.entities.Product;

@Component

public class ProductRepository {

	private Map<Long, Product> map = new HashMap<>();
	
	public void save(Product obj) {
		map.put(obj.getId(), obj);
	}

	public Product findById(Long id) { //método que retorna a categoria do id informado
		return map.get(id); //pesquisar no map se tem a categoria com id informado
	}
	
	public List<Product> findAll() {
		return new ArrayList<Product>(map.values());//Pega todos os valores e retorna uma nova lista com todos os valores.
		
	}

}
