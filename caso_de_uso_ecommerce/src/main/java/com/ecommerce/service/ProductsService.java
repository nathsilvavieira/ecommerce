package com.ecommerce.service;



import java.util.Optional;

import com.ecommerce.dto.ProductsDTO;

import com.ecommerce.entities.Products;


public interface ProductsService {

	public void save(ProductsDTO dto);
	
	public Optional<Products> findById(String sku);
	
	public void deleteById(String sku);
}
