package com.quiz.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.domain.Seller;
import com.quiz.lesson04.mapper.SellerMapper;

@Service
public class SellerBO {

	@Autowired
	private SellerMapper sellerMapper;
	
	// input : 파라미터
	// output : X
	public void addSeller(String nickname, String profileImageUrl, double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	// seller 출력
	// input : X
	// output : Seller(or null)
	public Seller getLatestSeller() {
		return sellerMapper.selectLatestSeller();
	}
	
	// seller 검색 출력
	// input : id
	// ouput : Seller(or null)
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
	
}
