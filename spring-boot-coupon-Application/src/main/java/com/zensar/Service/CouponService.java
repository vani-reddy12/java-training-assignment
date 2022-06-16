package com.zensar.Service;

import java.util.List;

import com.zensar.dto.CouponDto;

public interface CouponService {

	public CouponDto getCoupon(int couponId);

	public List<CouponDto> getAllCoupons(int pageNumber, int pageSize);

	public CouponDto insertCoupon(CouponDto coupon);

	public void updateCoupon(int couponId, CouponDto coupon);

	public void deleteCoupon(int couponId);
	
	List<CouponDto>getByCouponCode(String couponCode);

	List<CouponDto>findByCouponCodeAndExpiryDate(String couponCode,String expiryDate);
}