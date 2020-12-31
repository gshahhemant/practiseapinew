package com.practise.api.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practise.api.jpa.entity.Product;


public interface ProductRepoDAO extends JpaRepository<Product, Long>{
	
	
	//The 'FETCH' option can be used on a JOIN (either INNER JOIN or LEFT JOIN) to fetch the related entities in a single query instead of additional queries for each access of the object's lazy relationships.
	@Query("select p from Product p left join fetch p.item ")
	public List<Product> getAllProductWithItems();
	
}

