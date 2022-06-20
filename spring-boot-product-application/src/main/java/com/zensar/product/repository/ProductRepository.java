package com.zensar.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	@Query(value = " select * from product where product_name=:name", nativeQuery = true)

	List<Product> test(@Param("name") String productName);

	@Query(value = "from Product p where p.productName=:name and p.productPrice=:price", nativeQuery = true)

	List<Product> test1(@Param("name") String productName, @Param("price") int price);

}
