package com.example.product.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.product.mapper.ProductMapper;
import com.example.product.models.ProductDTO;
import com.example.product.models.ProductType;
import com.example.product.repository.ProductRepository;
import com.example.product.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Junit Test cases for Product using Mockito
 * 
 * @author home
 * @version 1.0
 */


//@WebMvcTest(controllers = ProductController.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	MockMvc mockmvc;

	@MockBean
	private ProductService service;

	/*@MockBean
	private ProductRepository repository;
	@MockBean
	private ProductMapper productMapper;*/

	/**
	 * GetProduct API Success
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("Getting a Product Success response")
	public void getProductTest() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.get("/api/product/{id}", 1)).andDo(print())
				.andExpect(status().is2xxSuccessful());
	}

	/**
	 * GetProducts API Success
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("Getting a Product List Success response")
	public void getProductsTest() throws Exception {

		mockmvc.perform(MockMvcRequestBuilders.get("/api/products")).andDo(print()).andExpect(status().isOk());
	}

	/**
	 * SaveProduct API Success
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("Saving a Product List Success response")
	public void saveProductTest() throws Exception {

		mockmvc.perform(
				MockMvcRequestBuilders.post("/api/product").content(asJsonString(new ProductDTO("Car", 12.0)))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().is2xxSuccessful());
		 //.andExpect(MockMvcResultMatchers.jsonPath("$.productid").exists());

	}

	/**
	 * Delete Product API Success
	 * 
	 * @throws Exception
	 */
	@Test
	@DisplayName("delete a Product Success response")
	public void deleteEmployeeAPI() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.delete("/api/product/remove/{id}", 1)).andDo(print())
				.andExpect(status().isAccepted());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
