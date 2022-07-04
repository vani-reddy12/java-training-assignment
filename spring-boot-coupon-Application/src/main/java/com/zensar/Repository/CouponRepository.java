package com.zensar.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
	@Query(value = "select * from coupon where coupon_code=:code", nativeQuery = true)
	List<Coupon> test(@Param("code") String couponCode);

	@Query(value = "from Coupon c where c.couponCode=:code and c.expiryDate=:date", nativeQuery = false)
	List<Coupon> test1(@Param("code") String couponCode, @Param("date") String date);
}
