package com.zensar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
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
//@RequestMapping(value = "/coupon-api", produces = { MediaType.APPLICATION_JSON_VALUE,
	//	MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
		//		MediaType.APPLICATION_XML_VALUE })
public class CouponController {
	@Autowired
	private CouponService couponService;
	/*
	 * @ExceptionHandler(value = CouponAlreadyExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.CONFLICT) public ErrorResponse
	 * handleCouponAlreadyExistsException(CouponAlreadyExistsException ex) {
	 * return new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage()); }
	 */
	  
	/*
	 * @ExceptionHandler(value = NoSuchCouponExistsException.class)
	 * 
	 * @ResponseStatus(HttpStatus.NOT_FOUND) public ErrorResponse
	 * handleNoSuchCouponExistsException(NoSuchCouponExistsException ex) { return
	 * new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage()); }
	 */
	@GetMapping(value = "/coupons/{couponId}")
	public ResponseEntity<CouponDto> getCoupon(@PathVariable("couponId") int couponId) {
		return new ResponseEntity<CouponDto>(couponService.getCoupon(couponId), HttpStatus.OK);

	}

	@GetMapping(value = "/coupons")
	public ResponseEntity<List<CouponDto>> getAllCoupons(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize,
	        @RequestParam(value = "sortBy", required = false, defaultValue = "couponCode") String sortBy,
            @RequestParam(value = "dir", required = false, defaultValue = "ASC") Direction dir){

		return new ResponseEntity<List<CouponDto>>(couponService.getAllCoupons(pageNumber, pageSize,sortBy,dir), HttpStatus.OK);
	}
	//@PostMapping(value = "/coupons",consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
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
	public ResponseEntity<String> deleteCoupon(@PathVariable("couponId") int couponId) {
		couponService.deleteCoupon(couponId);
		return new ResponseEntity<String>("Coupon deleted succesfully", HttpStatus.OK);
	}

	@GetMapping(value = "/coupons/code/{couponCode}")
	public ResponseEntity<List<CouponDto>> getByCouponCode(@PathVariable("couponCode") String couponCode) {
		return new ResponseEntity<List<CouponDto>>(couponService.getByCouponCode(couponCode), HttpStatus.OK);
	}

	@GetMapping(value = "/coupons/{couponCode}/{expiryDate}")
	public ResponseEntity<List<CouponDto>> findByCouponCodeAndExpiryDate(@PathVariable("couponCode") String couponCode,
			@PathVariable("expiryDate") String date) {
		return new ResponseEntity<List<CouponDto>>(couponService.findByCouponCodeAndExpiryDate(couponCode, date),
				HttpStatus.OK);
	}

}