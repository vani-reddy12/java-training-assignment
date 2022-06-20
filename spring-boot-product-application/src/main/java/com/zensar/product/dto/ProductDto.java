package com.zensar.product.dto;


public class ProductDto {
	private int productId;
	private String productName;
	private int productPrice;
	public ProductDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDto(int productId, String productName, int productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
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
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}

}
