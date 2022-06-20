package com.zensar.product.service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import com.zensar.product.dto.ProductDto;

public interface ProductService {
	public ProductDto getProduct(int productId);

	public List<ProductDto> getAllProducts(int pagNumber, int pageSize, String sortBy, Direction dir);

	public ProductDto insertProduct(ProductDto product);

	public void updateProduct(int productId, ProductDto product);

	public void deleteProduct(int productId);

	List<ProductDto> getByProductName(String productName);

	List<ProductDto> findByProductNameAndProductPrice(String productName, int price);

}
