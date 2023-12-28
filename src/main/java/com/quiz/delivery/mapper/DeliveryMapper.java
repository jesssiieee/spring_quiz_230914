package com.quiz.delivery.mapper;

import java.util.List;

import com.quiz.delivery.domain.Delivery;
import com.quiz.delivery.domain.DeliveryReview;

public interface DeliveryMapper {

	public List<Delivery> selectDeliveryList();
	
	public List<DeliveryReview> selectDeliveryReviewList();
	
}
