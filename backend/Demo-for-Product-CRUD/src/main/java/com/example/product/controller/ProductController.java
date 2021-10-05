package com.example.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.entity.Product;
import com.example.product.mapper.ProductMapper;
import com.example.product.models.ProductDTO;
import com.example.product.service.ProductService;

/**
 * Product Controller class for REST APIs
 * 
 * @author home
 * @version 1.0
 */

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	@Autowired
	private ProductService service;

	@Autowired
	private ProductMapper productMapper;

	/**
	 * Get Product REST API
	 * 
	 * @param id
	 * @return ProductDTO
	 */
	@GetMapping("/product/{id}")
	public ProductDTO getProduct(@PathVariable String id) {
		logger.info("getProduct() API invoked");
		Product product = service.getProduct(id);

		return productMapper.toProductDTO(product);
	}

	/**
	 * Get all Products REST API
	 * 
	 * @return List
	 */
	@GetMapping("/products")
	public List<Product> getProducts() {
		logger.info("getProducts() API invoked");
		List<Product> products = service.getProducts();

		return products;
	}

	/**
	 * Save product REST API
	 * 
	 * @param productdto
	 * @return new Product
	 */
	@PostMapping("/product")
	public Product saveProduct(@Valid @RequestBody ProductDTO productdto) {
		logger.info("saveProduct() API invoked");

		return service.saveProduct(productMapper.toProduct(productdto));
	}

	/**
	 * Delete a Product REST API
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/product/remove/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String id) {
		logger.info("deleteProduct() API invoked");
		service.deleteProduct(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.ACCEPTED);
	}

	@PutMapping("/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO updatedproduct, @PathVariable Long id) {
		logger.info("updateProduct() API invoked");
		Product product = service.updateProduct(id, updatedproduct);
		return ResponseEntity.ok(product);
	}

}
