package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
//@NamedQueries(value= {
 //      @NamedQuery(name="Coupon.test1",query="from coupon c where c.couponCode=?1 and c.expiryDate=?2")})
//@NamedNativeQuery(name="Coupon.test",query= "select * from coupon where coupon_code=?1",resultClass=Coupon.class)
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

	public void setexpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", expiryDate=" + expiryDate + "]";
	}

}