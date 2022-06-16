package com.zensar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Service.CouponService;
import com.zensar.Service.CouponServiceImpl;
import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

@RestController
@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CouponController {
	@Autowired
	private CouponService couponService;

	@GetMapping(value = "/coupons/{couponId}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		return new ResponseEntity<CouponDto>(couponService.getCoupon(couponId), HttpStatus.OK);

	}

	@GetMapping(value = { "/coupons", "/listOfCoupons" })
	public ResponseEntity<List<CouponDto>> getAllCoupons(@RequestParam(value="pageNumber",required = false,defaultValue="0")int pageNumber,@RequestParam(value="pageSize",required = false,defaultValue="5") int pageSize) {
		
		return new ResponseEntity<List<CouponDto>>(couponService.getAllCoupons(pageNumber,pageSize), HttpStatus.OK);
	}

	
	@PostMapping(value = "/coupons")
	public ResponseEntity<CouponDto> insertCoupon(@RequestBody CouponDto couponDto) {

		return new ResponseEntity<CouponDto>(couponService.insertCoupon(couponDto), HttpStatus.CREATED);

		// System.out.println("HI");
	}

	
	@PutMapping(value = "/coupons/{couponId}")
	public ResponseEntity<String> updateCoupon(@PathVariable("couponId") int couponId,
			@RequestBody CouponDto couponDto) {
		couponService.updateCoupon(couponId, couponDto);
		return new ResponseEntity<String>("Coupon updated succesfully", HttpStatus.OK);

	}

	
	@DeleteMapping("/coupons/{couponId}")
	public ResponseEntity<String> delete(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon deleted succesfully", HttpStatus.OK);
	}
	@GetMapping(value="/coupons/code/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCode(@PathVariable("couponCode")String couponCode) {
	return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCode(couponCode),HttpStatus.OK);
	}
	
	@GetMapping(value="/coupons/{couponCode}/{expiryDate}")
	public ResponseEntity<List<CouponDto>> findByCouponCodeAndExpiryDate(@PathVariable("couponCode")String couponCode,@PathVariable("expiryDate")String date) {
		return new ResponseEntity<List<CouponDto>>(couponService.findByCouponCodeAndExpiryDate(couponCode,date),HttpStatus.OK);
		}

}