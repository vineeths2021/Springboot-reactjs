package com.example.product.models;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * DTO class for Product
 * 
 * @author home
 * @version 1.0
 */
public class ProductDTO {

	public ProductDTO(String productname, Double rate) {
		this.productname = productname;
		this.productrate = rate;

	}

	@NotNull(message = "Please enter product name")
	@NotBlank(message = "Field should not be blank")
	@Size(min = 1, max = 500, message = "Please enter values between 1 to 500")
	private String productname;

	@NotNull(message = "Please enter product rate")
	private Double productrate;

	private ProductType producttype;

	private String productdescription;

	private LocalDate expirydate;

	private LocalDate manufacturedate;

	public ProductDTO() {
		super();

	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getProductrate() {
		return productrate;
	}

	public void setProductrate(Double productrate) {
		this.productrate = productrate;
	}

	public ProductType getProducttype() {
		return producttype;
	}

	public void setProducttype(ProductType producttype) {
		this.producttype = producttype;
	}

	public String getProductdescription() {
		return productdescription;
	}

	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}

	public LocalDate getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(LocalDate expirydate) {
		this.expirydate = expirydate;
	}

	public LocalDate getManufacturedate() {
		return manufacturedate;
	}

	public void setManufacturedate(LocalDate manufacturedate) {
		this.manufacturedate = manufacturedate;
	}

	@Override
	public String toString() {
		return "ProductDTO [productname=" + productname + ", productrate=" + productrate + ", producttype="
				+ producttype + ", productdescription=" + productdescription + ", expirydate=" + expirydate
				+ ", manufacturedate=" + manufacturedate + "]";
	}

}
