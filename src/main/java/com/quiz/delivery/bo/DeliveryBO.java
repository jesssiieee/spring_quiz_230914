package com.quiz.delivery.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.delivery.domain.Delivery;
import com.quiz.delivery.domain.DeliveryJoin;
import com.quiz.delivery.domain.DeliveryReview;
import com.quiz.delivery.mapper.DeliveryMapper;

@Service
public class DeliveryBO {
	
	@Autowired
	private DeliveryMapper deliveryMapper;

	public List<Delivery> getDeliveryList() {
		return deliveryMapper.selectDeliveryList();
	}
	
	public List<DeliveryReview> getDeliveryReviewList() {
		return deliveryMapper.selectDeliveryReviewList();
	}
	
	public List<DeliveryJoin> getDeliveryJoinList() {
		return deliveryMapper.selectDeliveryJoinList();
	}
	
	
	
}
