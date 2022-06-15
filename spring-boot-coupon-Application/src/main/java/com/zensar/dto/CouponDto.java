package com.zensar.dto;

public class CouponDto {


	private int couponId;
	private String couponCode;
	private int expiryDate;
	public CouponDto() {
		super();
	}
	public CouponDto(int couponId, String couponCode, int expiryDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expiryDate = expiryDate;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	public int getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(int expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "CouponDto [couponId=" + couponId + ", couponCode=" + couponCode + ", expiryDate=" + expiryDate + "]";
	}
}
	
	