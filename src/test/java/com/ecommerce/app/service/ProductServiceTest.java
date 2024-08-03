package com.ecommerce.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {

	@MockBean
	private ProductService service;

	@MockBean
	private ProductRepository repository;

	//@Test
	public void getAllProducts() {
		when(repository.findAll()).thenReturn(
				Stream.of(new Product(376, "pen", "ball pen", new BigDecimal("1000.50"))).collect(Collectors.toList()));
		assertEquals(1, service.getAllProducts().size());
	}
}
