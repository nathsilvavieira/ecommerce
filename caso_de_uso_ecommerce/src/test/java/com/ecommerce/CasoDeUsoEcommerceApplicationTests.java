package com.ecommerce;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ecommerce.entities.Products;
import com.ecommerce.repository.ProductsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class CasoDeUsoEcommerceApplicationTests {

	@Autowired
	ProductsRepository repository;

	@Test
	void testCreate() {
		Products products = new Products();
		products.setSku("CE123");
		products.setDesc("IphoneX");
		products.setPrice(1200);
		products.setSize(1.2);
		products.setMaterial("Apple Inc");
		repository.save(products);
	}


}
