package com.example.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.product.entity.Product;
import com.example.product.models.ProductType;
import com.example.product.repository.ProductRepository;

/**
 * Service Layer unit testcases with Mockito
 * 
 * @author Vineeth
 *
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceMockitoTest {

	@InjectMocks
	private ProductService service = new ProductService();

	@Mock
	private ProductRepository repository;

	@DisplayName(" Product save Success")
	@Test
	public void testSaveProductServiceSuccess() {
		// create a product
		Product product = new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		product.setProducttype(ProductType.AUTOMOBILE);
		product.setProductdescription("Car is Autombile Part");
		product.setExpirydate(LocalDate.of(2022, 12, 31));
		when(repository.save(any(Product.class))).thenReturn(product);

		// save the product
		Product newProduct = service.saveProduct(product);

		// verify the save
		assertEquals("Car", newProduct.getProductname());
	}

	@DisplayName(" Product get Success")
	@Test
	public void testGetProductServiceSuccess() {

		String id = "1";
		// create a product
		Product product = new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		product.setProducttype(ProductType.AUTOMOBILE);
		product.setProductdescription("Car is Autombile Part");
		product.setExpirydate(LocalDate.of(2022, 12, 31));
		Optional<Product> returnProduct = Optional.of((Product) product);

		when(repository.findById(Long.valueOf(id))).thenReturn(returnProduct);

		// get the product
		Product newproduct = service.getProduct(id);

		// verify the save
		assertEquals("Car", newproduct.getProductname());
	}

	@DisplayName(" Product get All Success")
	@Test
	public void testGetAllProductServiceSuccess() {

		// create a product
		Product product = new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		product.setProducttype(ProductType.AUTOMOBILE);
		product.setProductdescription("Car is Autombile Part");
		product.setExpirydate(LocalDate.of(2022, 12, 31));
		List<Product> returnProduct = new ArrayList<Product>();
		returnProduct.add(product);
		when(repository.findAll()).thenReturn(returnProduct);

		// get all the product
		List<Product> newproductlist = service.getProducts();

		// verify the save

		assertEquals(1, newproductlist.size());
	}

	@DisplayName(" Product delete Success")
	@Test
	public void testdeleteProductServiceSuccess() {

		final Product product = new Product();
		product.setProductname("Car");
		product.setProductrate(120000.0);
		product.setProducttype(ProductType.AUTOMOBILE);
		product.setProductdescription("Car is Autombile Part");
		product.setExpirydate(LocalDate.of(2022, 12, 31));
		Optional<Product> optionalEntityType = Optional.of(product);
		when(repository.findById(1L)).thenReturn(optionalEntityType);

		// when
		service.deleteProduct("1");

		// then
		verify(repository, times(1)).delete(product);

	}
	
	@DisplayName(" Product delete Failure for incorrect id")
	@Test
	public void testdeleteProductServiceFailureForInvalidInput() {

		String id="10000000";
		
		when(repository.findById(Long.valueOf(id))).thenThrow(IllegalArgumentException.class);

		assertThrows(IllegalArgumentException.class,
			      () -> service.deleteProduct(id));
	}
	@DisplayName(" Product delete Failure for null id")
	@Test
	public void testdeleteProductServiceFailureForInvalidData() {

		String id="1";
		
		when(repository.findById(Long.valueOf(id))).thenThrow(NullPointerException.class);

		assertThrows(NullPointerException.class,
			      () -> service.deleteProduct(id));
	}
	@DisplayName(" Product save Failure Scenerio for Wrong data")
	@Test
	public void testSaveProductServiceFailureForWrongData() {
		// create a product
		Product product = new Product();
		product.setProductname("##$%^^");
		product.setProductrate(120000.0);
		product.setProducttype(ProductType.AUTOMOBILE);
		product.setProductdescription("$#$$#^^#^#");
		product.setExpirydate(LocalDate.of(2022, 12, 31));
	

		when(repository.save(any(Product.class))).thenThrow(IllegalArgumentException.class);

		assertThrows(IllegalArgumentException.class,
			      () -> service.saveProduct(product));
	}
	
}
