package com.example.product.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.product.entity.Product;
import com.example.product.models.ProductDTO;

/**
 * Mapper for Product
 * 
 * @author home
 * @version
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
	ProductDTO toProductDTO(Product product);

	List<ProductDTO> toProductDTOs(List<Product> products);

	Product toProduct(ProductDTO productDTO);
}
