package com.ecommerce.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entities.Products;


@Repository
public interface ProductsRepository extends CrudRepository<Products, String> {


}
