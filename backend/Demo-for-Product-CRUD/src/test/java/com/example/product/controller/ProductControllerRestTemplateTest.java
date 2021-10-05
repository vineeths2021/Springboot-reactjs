package com.example.product.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import antlr.collections.List;

/**
 * RestTemplate Controller based Testing
 * 
 * @author home
 * @version 1.0
 */

@Disabled
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerRestTemplateTest {

	@LocalServerPort
	private int port;

	private String url;

	@Autowired
	private TestRestTemplate restTemplate;

	@BeforeEach
	public void setUp() {
		url = String.format("http://localhost:%d/api/products", port);

	}

	@Test
	public void getProduct() {

		assertThat(this.restTemplate.getForEntity(url, List.class)).asList();

	}

}
