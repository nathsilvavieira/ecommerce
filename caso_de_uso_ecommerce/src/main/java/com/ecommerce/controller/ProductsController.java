package com.ecommerce.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.ProductsDTO;
import com.ecommerce.entities.Products;
import com.ecommerce.service.ProductsService;




@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductsService service;
	
	@PostMapping()
	public ResponseEntity<Void> save(@RequestBody ProductsDTO dto){
		service.save(dto);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	
	@GetMapping("/{sku}")
    public ResponseEntity<Optional<Products>> findById(@PathVariable String sku){
		
        return ResponseEntity.ok(service.findById(sku));
    }
	
	 @DeleteMapping("/{sku}")
	 public ResponseEntity<Optional<Products>> deleteById(@PathVariable String sku){
		 service.deleteById(sku);
	     return ResponseEntity.status(HttpStatus.OK).build();
	        		
	 }
	 
	 @PutMapping()
	 public ResponseEntity<Optional<Products>> saveChange(@RequestBody ProductsDTO dto){
		 if(service.findById(dto.getSku()).isPresent()){
			 service.save(dto);
			 return ResponseEntity.status(HttpStatus.OK).build();
		 }		 
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	 }
	
	
	
	

}
