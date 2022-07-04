package com.zensar.product.entity;

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
	private int couponPrice;
	private String couponDesc;
	private int discount;
	public Coupon(int couponId, String couponCode, String expiryDate, int couponPrice, String couponDesc,
			int discount) {
		super();
		this.couponId = couponId;
		this.couponCode = couponCode;
		this.expiryDate = expiryDate;
		this.couponPrice = couponPrice;
		this.couponDesc = couponDesc;
		this.discount = discount;
	}
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
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
	public int getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public String toString() {
		return "Coupon [couponId=" + couponId + ", couponCode=" + couponCode + ", expiryDate=" + expiryDate
				+ ", couponPrice=" + couponPrice + ", couponDesc=" + couponDesc + ", discount=" + discount + "]";
	}

}