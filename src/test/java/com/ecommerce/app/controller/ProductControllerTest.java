package com.ecommerce.app.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ecommerce.app.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class ProductControllerTest {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext context;

	ObjectMapper om = new ObjectMapper();

	@BeforeEach
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void addProductTest() throws Exception {
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("laptop");
		product.setProductDescription("hp 8 gb, 512 gb rom");
		product.setProductPrice(new BigDecimal("9000.00"));
		String jsonRequest = om.writeValueAsString(product);
		MvcResult result = mockMvc.perform(
				post("/api/product/addNewProduct").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		assertNotNull(resultContent);

	}

}
