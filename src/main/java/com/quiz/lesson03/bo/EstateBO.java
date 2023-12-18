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
	
	
}
