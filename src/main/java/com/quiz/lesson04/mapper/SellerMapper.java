package com.quiz.lesson04.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson04.domain.Seller;

@Mapper
public interface SellerMapper {

	public void insertSeller(
			@Param("nickname") String nickname, 
			@Param("profileImageUrl") String profileImageUrl, 
			@Param("temperature") double temperature);
	
	// 2.seller 출력
	public Seller selectLatestSeller();
	
	// 3. seller 검색 출력
	public Seller selectSellerById(int id);
	
}
