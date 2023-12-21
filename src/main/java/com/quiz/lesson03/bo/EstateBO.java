package com.quiz.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.domain.Estate;
import com.quiz.lesson03.mapper.EstateMapper;

@Service
public class EstateBO {

	@Autowired EstateMapper estateMapper;
	
	public Estate getEstate(int id) {
		return estateMapper.selectEstateById(id);
	}
	
	public List<Estate> getEstateListByRent(int rent_price) {
		return estateMapper.selectEstateListByRent(rent_price);
	}
	
	public List<Estate> getEstateListAreaPrice(int area, int price) {
		return estateMapper.selectEstateListByAreaPrice(area, price);
	}
	
	// input : Estate
	// output : 성공한 행의 개수
	public int addEstate(Estate estate) {
		return estateMapper.insertEstate(estate);
	}
	
	public int addEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
	
		return estateMapper.insertEstateAsField(realtorId, address, area, type, price, rentPrice);
		
	}
	
	public int updateEstateById(int id, String type, int price) {
		return estateMapper.updateEstateById(id, type, price);
	}
	
	// quiz04 delete
	public int deleteEstateById(int id) {
		return estateMapper.deleteEstateById(id);
	}
	
	
}