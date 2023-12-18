package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.Estate;

@Repository
public interface EstateMapper {

	public Estate selectEstateById(int id);
	
	public List<Estate> selectEstateListByRent(int rent_price);
	
	public List<Estate> selectEstateListByAreaPrice(@Param("area") int area, @Param("price") int price);
	
}
