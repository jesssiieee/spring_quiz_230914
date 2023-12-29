package com.quiz.delivery.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.delivery.domain.Delivery;
import com.quiz.delivery.domain.DeliveryJoin;
import com.quiz.delivery.domain.DeliveryReview;

@Repository
public interface DeliveryMapper {

	public List<Delivery> selectDeliveryList();
	
	public List<DeliveryReview> selectDeliveryReviewList();
	
	public List<DeliveryJoin> selectDeliveryJoinList();
	
}
