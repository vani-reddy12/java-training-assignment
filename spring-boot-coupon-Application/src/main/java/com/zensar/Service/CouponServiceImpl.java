package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.Repository.CouponRepository;
import com.zensar.dto.CouponDto;
import com.zensar.entity.Coupon;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CouponDto getCoupon(int couponId) {
		Coupon getcoupon=couponRepository.findById(couponId).get();
		
		 return modelMapper.map(getcoupon,CouponDto.class);
		
	}

	@Override
	public List<CouponDto> getAllCoupons() {
		List<Coupon>listOfCoupons=couponRepository.findAll();
		List<CouponDto>listOfCouponDto = new ArrayList<CouponDto>();
		 
		for(Coupon coupon:listOfCoupons) {
			
			listOfCouponDto.add(modelMapper.map(coupon,CouponDto.class));
			}
			return listOfCouponDto;
		
	}

	@Override
	public CouponDto insertCoupon(CouponDto couponDto) {
		
		Coupon coupon = modelMapper.map(couponDto,Coupon.class);
		Coupon insertedCoupon=couponRepository.save(coupon);
	
		return modelMapper.map(insertedCoupon,CouponDto.class);
		
		//return maptoDto;

	}

	@Override
	public void updateCoupon(int couponId, CouponDto couponDto) {
		
		
		Coupon coupon = modelMapper.map(couponDto, Coupon.class);
		Coupon updatedCoupon=couponRepository.save(coupon);



	}

	@Override
	public void deleteCoupon(int couponId) {
		
		couponRepository.deleteById(couponId); 

	}
}
	/*public CouponDto mapToDto(Coupon coupon) {
		CouponDto dto=new CouponDto();
		dto.setCouponCode(coupont.getCouponCode());
		dto.setCouponId(dto.getCouponId());
		dto.setexpiryDate(dto.getexpiryDate());
		return dto;
		
	}

	public Coupon mapToEntity(CouponDto couponDto) {
		Coupon coupon=new Coupon();
		coupon.setCouponId(couponDto.getCouponId());
		coupon.setCouponCode(couponDto.getCouponCode());
		coupon.setexpiryDate(couponDto.getexpiryDate());
		return coupon;
	}*/
		

