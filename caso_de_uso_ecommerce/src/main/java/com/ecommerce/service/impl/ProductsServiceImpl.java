package com.ecommerce.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ProductsDTO;
import com.ecommerce.entities.Products;
import com.ecommerce.repository.ProductsRepository;
import com.ecommerce.service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	ProductsRepository repository;
	

	@Override
	public void save(ProductsDTO dto){
		Products products = new Products();		
		products.setSku(dto.getSku());
		products.setBrand(dto.getBrand());
		products.setDesc(dto.getDesc());
		products.setPrice(dto.getPrice());
		products.setSize(dto.getSize());
		products.setMaterial(dto.getMaterial());
		repository.save(products);

	}
	
	@Override
	public Optional<Products> findById(String sku) {
		Optional<Products> product = repository.findById(sku);
		return product;
		
	}
	
	@Override
	public void deleteById(String sku){
		if(repository.existsById(sku)){
			repository.deleteById(sku);
		}
	}
	
	
	

}
