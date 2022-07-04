package com.zensar.product.dto;

public class CouponDto {

	private int couponId;
	private String couponCode;
	private String expiryDate;
	private String couponDesc;
	private int couponPrice;
	private int discount;

	public CouponDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CouponDto(int couponId, String couponCode, String expiryDate, String couponDesc, int couponPrice,
			int discount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expiryDate = expiryDate;
		this.couponDesc = couponDesc;
		this.couponPrice = couponPrice;
		this.discount = discount;
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

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	public int getCouponPrice() {
		return couponPrice;
	}

	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "CouponDto [couponId=" + couponId + ", couponCode=" + couponCode + ", expiryDate=" + expiryDate
				+ ", couponDesc=" + couponDesc + ", couponPrice=" + couponPrice + ", discount=" + discount + "]";
	}
}
