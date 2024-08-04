package com.ecommerce.app.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exception.ProductNotFoundException;
import com.ecommerce.app.repository.ProductRepository;
import com.ecommerce.app.request.ProductRequest;
import com.ecommerce.app.response.ProductResponse;
import com.ecommerce.app.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public long addNewProduct(ProductRequest productRequest) {
		Product product = Product.builder().productName(productRequest.getProductName())
				.productDescription(productRequest.getProductDescription())
				.productPrice(productRequest.getProductPrice()).build();
		productRepository.save(product);
		log.info("Product {} is saved", product.getProductId());
		return product.getProductId();
	}

	@Override
	public ProductResponse getProductById(long productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("Product is not found foe this id :" + productId));
		return ProductResponse.builder().productId(product.getProductId())
				.productName(product.getProductName()).productDescription(product.getProductDescription())
				.productPrice(product.getProductPrice()).build();
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public void deleteAllProducts() {
		productRepository.deleteAll();
	}

	@Override
	public Map<String, Boolean> deleteProductById(long productId) throws ProductNotFoundException {
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("product not found with product id :" + productId));
		productRepository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		String result = "Product delete successFull with product Id :" + productId;
		response.put(result, Boolean.TRUE);
		return response;
	}

	@Override
	public Product updateProduct(Long productId, ProductRequest productRequest) throws ProductNotFoundException {
		Product existingProduct = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("product not found with product id :" + productId));
		existingProduct.setProductName(productRequest.getProductName());
		existingProduct.setProductDescription(productRequest.getProductDescription());
		existingProduct.setProductPrice(productRequest.getProductPrice());
		return productRepository.save(existingProduct);
	}

}
