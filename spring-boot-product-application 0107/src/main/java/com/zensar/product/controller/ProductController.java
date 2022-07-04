package com.zensar.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.product.dto.ProductDto;
import com.zensar.product.service.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping(value = "/product-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class ProductController {
	@Autowired
	private ProductService productService;

	// http://localhost:9999/product/1001 GET
	// @RequestMapping(value = "/products/{productId}",method=RequestMethod.GET)
	@GetMapping(value = "/products/{productId}")
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {
		return new ResponseEntity<ProductDto>(productService.getProduct(productId), HttpStatus.OK);

	}

	// http://localhost:9999/products
	// @RequestMapping(value = { "/products",
	// "/listOfProducts"},method=RequestMethod.GET)
	@GetMapping(value = { "/products", "/listOfProducts" })
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "productName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir) {

		return new ResponseEntity<List<ProductDto>>(productService.getAllProducts(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	// http://localhost:9999/products POST
	// @RequestMapping(value = "/products",method=RequestMethod.POST)
	@PostMapping(value = "/products")
	
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {

		// restClient.getCoupon(productDto.get)


		// return productService.insert(productDto);
		return new ResponseEntity<ProductDto>(productService.insertProduct(productDto), HttpStatus.CREATED);

		// System.out.println("HI");
	}

	// @RequestMapping(value="/products/{productId}",method=RequestMethod.PUT)
	@PutMapping(value = "/products/{productId}")
	public ResponseEntity<String> update(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {
		productService.updateProduct(productId, productDto);
		return new ResponseEntity<String>("Product updated succesfully", HttpStatus.OK);

	}

	// http://localhost:9999/products/1001 -> Delete
	// @RequestMapping(value="/products/{productId}",method=RequestMethod.DELETE)
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Product deleted succesfully", HttpStatus.OK);
	}

	@GetMapping(value = "/products/name/{productName}")
	public ResponseEntity<List<ProductDto>> getByProductName(@PathVariable("productName") String productName) {
		return new ResponseEntity<List<ProductDto>>(productService.getByProductName(productName), HttpStatus.OK);
	}


	@GetMapping(value = "/products/{productName}/{productPrice}")
	public ResponseEntity<List<ProductDto>> findByProductNameAndProductPrice(
			@PathVariable("productName") String productName, @PathVariable("productPrice") int price) {
		return new ResponseEntity<List<ProductDto>>(productService.findByProductNameAndProductPrice(productName, price),
				HttpStatus.OK);
	}

}
