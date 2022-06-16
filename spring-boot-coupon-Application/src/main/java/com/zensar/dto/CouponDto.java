package com.zensar.dto;

public class CouponDto {


	private int couponId;
	private String couponCode;
	private String expiryDate;
	public CouponDto() {
		super();
	}
	public CouponDto(int couponId, String couponCode, String expiryDate) {
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
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "CouponDto [couponId=" + couponId + ", couponCode=" + couponCode + ", expiryDate=" + expiryDate + "]";
	}
	
}
	