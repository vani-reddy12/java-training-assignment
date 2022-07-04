package com.zensar.product.dto;

import javax.persistence.Transient;

public class ProductDto {
	private int productId;
	private String productName;
	private int productPrice;
	private int productQuantity;
	@Transient
	private String couponCode;

	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductDto(int productId, String productName, int productPrice, int productQuantity, String couponCode) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.couponCode = couponCode;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", couponCode=" + couponCode + "]";
	}

}
