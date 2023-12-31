package com.quiz.lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.lesson05.bo.ReviewBO;
import com.quiz.lesson05.domain.Review;


@Controller
@RequestMapping("/lesson05")
public class Lesson05Quiz06Controller {

	@Autowired
	private StoreBO storeBO;
	
	@Autowired
	private ReviewBO reviewBO;
	
	// 1. 가게 목록 화면
	// url : http://localhost:8080/lesson05/quiz06/store-list
	@RequestMapping("/quiz06/store-list")
	public String storeList(Model model) {
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		
		return "lesson05/quiz06/store-list";
	}
	
	// 2. 리뷰화면
	// url : http://localhost:8080/lesson05/quiz06/review
	// ?storeId=3&storeName=BHC
	@RequestMapping("/quiz06/review")
	public String review(
//			@RequestParam("storeId") int storeId,
//			@RequestParam("storeName") String storeName,
			Model model) {
		
//		List<Review> reviewList = reviewBO.getReviewByStoreId(storeId);
//		model.addAttribute("reviewList", reviewList);
//		model.addAttribute("storeName", storeName);
		
		return "lesson05/quiz06/review";
	}
	
	
}
