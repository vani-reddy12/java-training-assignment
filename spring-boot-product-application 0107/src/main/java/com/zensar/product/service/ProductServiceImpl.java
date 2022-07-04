package com.zensar.product.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.zensar.product.dto.ProductDto;
import com.zensar.product.entity.Product;
import com.zensar.product.exceptions.NoSuchProductExistsException;
import com.zensar.product.repository.ProductRepository;

import org.springframework.data.domain.Sort.Direction;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto getProduct(int productId) {
		Product getproduct = productRepository.findById(productId).get();
		// ProductDto dto=mapToDto(product);
		return modelMapper.map(getproduct, ProductDto.class);
		// return dto;
	}

	@Override
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, String sortBy, Direction dir) {

		// List<Student>listOfStudents=studentRepository.findAll();
		List<ProductDto> listOfProductDto = new ArrayList<ProductDto>();

		Page<Product> findAll = productRepository.findAll(PageRequest.of(pageNumber, pageSize, dir, sortBy));

		// Page<Product> findAll = productRepository
		// .findAll(PageRequest.of(pageNumber, pageSize, Direction.DESC,
		// "productName"));

		List<Product> content = findAll.getContent();

		for (Product product : content) {
			// listOfProductDto.add(mapToDto(product));
			listOfProductDto.add(modelMapper.map(product, ProductDto.class));
		}

		return listOfProductDto;

	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		// Product product = mapToEntity(productDto);
		Product product = modelMapper.map(productDto, Product.class);
		Product insertedProduct = productRepository.save(product);
		// ProductDto dto = new ProductDto();
		return modelMapper.map(insertedProduct, ProductDto.class);

		// return maptoDto;

	}

	@Override
	public void updateProduct(int productId, ProductDto productDto) {
		Product getProduct = productRepository.findById(productId).orElse(null);
		if (getProduct == null)
			throw new NoSuchProductExistsException("Product doesn't exists to update it");
		productRepository.save(modelMapper.map(productDto, Product.class));
	
	// Product product=mapToEntity(productDto);
	// Product product = modelMapper.map(productDto, Product.class);
	// Product updatedStudent = productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		Product getProduct = productRepository.findById(productId).orElse(null);
		if (getProduct == null)
			throw new NoSuchProductExistsException("Product doesn't exists to delete it");
		productRepository.deleteById(productId);

	}
	/*
	 * public ProductDto mapToDto(Product product) { ProductDto dto=new
	 * ProductDto(); dto.setProductPrice(product.getProductPrice());
	 * dto.setProductId(dto.getProductId());
	 * dto.setProductName(dto.getProductName()); return dto;
	 * 
	 * }
	 * 
	 * public Product mapToEntity(ProductDto productDto) { Product product=new
	 * Product(); product.setProductId(productDto.getProductId());
	 * product.setProductName(productDto.getProductName());
	 * product.setProductPrice(productDto.getProductPrice()); return product; }
	 */

	@Override
	public List<ProductDto> getByProductName(String productName) {
		List<ProductDto> productDtos = new ArrayList();
		List<Product> products = productRepository.test(productName);
		for (Product product : products)
			productDtos.add(modelMapper.map(product, ProductDto.class));
		return productDtos;

		// return productRepository.getByProductName(productName);
		// return productRepository.findByProducttName(productName);
	}

	@Override
	public List<ProductDto> findByProductNameAndProductPrice(String productName, int price) {
		List<ProductDto> productDtos = new ArrayList();
		List<Product> products = productRepository.test1(productName, price);
		for (Product product : products)
			productDtos.add(modelMapper.map(product, ProductDto.class));
		return productDtos;
	}
	
}
