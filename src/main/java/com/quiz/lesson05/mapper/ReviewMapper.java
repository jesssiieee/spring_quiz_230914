package com.quiz.lesson05.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.lesson05.domain.Review;

@Repository
public interface ReviewMapper {
	
	public List<Review> selectReviewByStoreId(int storeId);
	
}
