package com.quiz.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.delivery.bo.DeliveryBO;
import com.quiz.delivery.domain.Delivery;
import com.quiz.delivery.domain.DeliveryJoin;
import com.quiz.delivery.domain.DeliveryReview;

@Controller
@RequestMapping("/delivery")
public class DeliveryController {
	
	@Autowired
	private DeliveryBO deliveryBO;

	// url : http://localhost:8080/delivery/delivery-view
	@GetMapping("/delivery-view")
	public String deliveryView(Model model) {
		
		List<Delivery> deliveryList = deliveryBO.getDeliveryList();
		model.addAttribute("deliveryList", deliveryList);
		
		return "delivery/deliveryView";
		
	}
	
	// url : http://localhost:8080/delivery/delivery-review
	@GetMapping("/delivery-review")
	public String deliveryReview(Model model) {
		
		List<DeliveryReview> deliveryReviewList = deliveryBO.getDeliveryReviewList();
		model.addAttribute("deliveryReviewList", deliveryReviewList);
		
		return "delivery/deliveryReview";
	}
	
	// url : http://localhost:8080/delivery/delivery-reviewjoin
	@GetMapping("/delivery-reviewjoin")
	public String deliveryReviewJoinList(Model model) {
		
		List<DeliveryJoin> deliveryJoin = deliveryBO.getDeliveryJoinList();
		model.addAttribute("deliveryJoin", deliveryJoin);
		
		return "delivery/deliveryReview";
		
	}
	
}
