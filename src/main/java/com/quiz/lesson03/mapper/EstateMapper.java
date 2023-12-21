package com.quiz.lesson03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.domain.Estate;

@Repository
public interface EstateMapper {

	public Estate selectEstateById(int id);
	
	public List<Estate> selectEstateListByRent(int rent_price);
	
	public List<Estate> selectEstateListByAreaPrice(
			// myBatis 문법 상 파라미터는 단 한개만 xml으로 보낼 수 있다.
			// 파라미터들을 하나의 맵에 담아서 보낸다.
			// 맵으로 만들어주는 어노테이선 @Param
			@Param("area") int area, 
			@Param("price") int price);
	
	public int insertEstate(Estate estate);
	
	public int insertEstateAsField(
			@Param("realtorId") int realtorId, 
			@Param("address") String address, 
			@Param("area") int area, 
			@Param("type") String type, 
			@Param("price") int price, 
			@Param("rentPrice") Integer rentPrice
			);
	
	public int updateEstateById(
			@Param("id") int id, 
			@Param("type") String type, 
			@Param("price") int price);
	
	// quiz04
	public int deleteEstateById(int id);
	
}
