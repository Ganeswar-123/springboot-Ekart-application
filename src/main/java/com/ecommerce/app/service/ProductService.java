package com.ecommerce.app.service;

import java.util.List;
import java.util.Map;

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exception.ProductNotFoundException;
import com.ecommerce.app.request.ProductRequest;
import com.ecommerce.app.response.ProductResponse;

public interface ProductService {

	long addNewProduct(ProductRequest productRequest);

	ProductResponse getProductById(long productId) throws ProductNotFoundException;

	List<Product> getAllProducts();

	Product updateProduct(Long productId, ProductRequest productRequest) throws ProductNotFoundException;

	Map<String, Boolean> deleteProductById(long productId) throws ProductNotFoundException;

	void deleteAllProducts();

}
