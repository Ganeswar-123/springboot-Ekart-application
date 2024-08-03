package com.ecommerce.app.controller;

import java.util.List;
import java.util.Map;

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

import com.ecommerce.app.entity.Product;
import com.ecommerce.app.exception.ProductNotFoundException;
import com.ecommerce.app.request.ProductRequest;
import com.ecommerce.app.response.ProductResponse;
import com.ecommerce.app.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Tag(name = "Ekart", description = "Ekart management APIs")
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/addNewProduct")
	public ResponseEntity<String> addNewProduct(
			// @RequestHeader("Ganesh") String name,
			@Valid @RequestBody ProductRequest productRequest) {
		long productId = productService.addNewProduct(productRequest);
		return ResponseEntity.ok().body("product saved with productId : " + productId);
	}
	
	@Operation(
		      summary = "Retrieve a Product by Id",
		      description = "Get a Product object by specifying its id. The response is Product object with id, title, description and published status.",
		      tags = { "product", "get" })
		  @ApiResponses({
		      @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ProductResponse.class), mediaType = "application/json") }),
		      @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
		      @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

	@GetMapping("/getProductById/{productId}")
	public ResponseEntity<ProductResponse> getProductById(@PathVariable(value = "productId") Long productId)
			throws ProductNotFoundException {
		ProductResponse productResponse = productService.getProductById(productId);
		return ResponseEntity.ok().body(productResponse);
	}

	@GetMapping("/product/getAllProducts")
	public List<Product> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		return products;
	}

	@PutMapping("/updateProduct/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "productId") Long productId,
			@Valid @RequestBody ProductRequest productRequest) throws ProductNotFoundException {
		Product updateProduct = productService.updateProduct(productId, productRequest);
		return ResponseEntity.ok(updateProduct);

	}

	@DeleteMapping("/product/deleteAllProducts")
	public ResponseEntity<String> deteteAllProducts() {
		productService.deleteAllProducts();
		return new ResponseEntity<String>("delete all product", HttpStatus.NO_CONTENT);

	}

	@DeleteMapping("/deleteProductsByID/{productId}")
	public Map<String, Boolean> deleteProductById(@PathVariable(value = "productId") Long productId)
			throws ProductNotFoundException {
		return productService.deleteProductById(productId);

	}
}
