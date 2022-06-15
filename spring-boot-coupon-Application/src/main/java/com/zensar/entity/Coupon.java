package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coupon {
	@Id
	private int couponId;
	private String couponCode;
	private String expiryDate;

	public Coupon() {
		super();
	}

	public Coupon(int couponId, String couponCode, String expiryDate) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expiryDate= expiryDate;
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

	public String getexpiryDate() {
		return expiryDate;
	}

	public void expiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", expiryDate=" + expiryDate + "]";
	}

}