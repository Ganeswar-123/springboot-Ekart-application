package com.ecommerce.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ecommerce.app.entity.Product;
import com.ecommerce.app.repository.ProductRepository;
import com.ecommerce.app.service.ProductService;

@SpringBootTest
class SpringbootEkartApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void main() {
		SpringbootEkartApplication.main(new String[] {});
	}

	

	

	
}
