package com.example.product.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.product.models.ProductType;

/**
 * Product Entity class
 * @author Vineeth
 * @version 1.0
 */


@Table(name="TBL_PRODUCT")
@Entity
public class Product {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="productid")
	private Long productid;
	
	@Column(name ="product_name")
	private String productname;
	
	@Column(name ="product_rate")
	private double productrate;
  
	@Column(name ="product_type")
	@Enumerated(EnumType.STRING)
	private ProductType producttype;
	
	@Column(name ="product_description")
	private String productdescription;
	
	@Column(name = "product_expiry_date", columnDefinition = "DATE")
	private LocalDate expirydate;
	
	@Column(name = "product_manufacture_date", columnDefinition = "DATE")
	private LocalDate manufacturedate;
	
	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public double getProductrate() {
		return productrate;
	}

	public void setProductrate(double productrate) {
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
		return "Product [productid=" + productid + ", productname=" + productname + ", productrate=" + productrate
				+ ", producttype=" + producttype + ", productdescription=" + productdescription + ", expirydate="
				+ expirydate + ", manufacturedate=" + manufacturedate + "]";
	}
	
}
