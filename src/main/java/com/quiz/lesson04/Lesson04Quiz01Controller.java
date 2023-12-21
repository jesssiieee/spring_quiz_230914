package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.domain.Seller;



@Controller
@RequestMapping("/lesson04/quiz01")
public class Lesson04Quiz01Controller {

	@Autowired
	private SellerBO sellerBO;
	
	// 판매자 추가 화면
	// url : http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// DB insert => 입력 성공 화면
	// url : http://localhost:8080/lesson04/quiz01/add-seller
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname")String nickname,
			@RequestParam( value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature ) {
		
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		// db insert
		return "lesson04/afterAddSeller";
	}
	
	// 최근 가입자 한명 화면 (id 파라미터가 없을 경우)
	// http://localhost:8080/lesson04/quiz01/seller-info-view
	// seller 검색 출력 (id 파라미터가 존재할 경우)
	// http://localhost:8080/lesson04/quiz01/seller-info-view?id=1
	@GetMapping("/seller-info-view")
	public String sellerInfoView(
			@RequestParam(value = "id", required = false) Integer id, 
			Model model) {
		
		// DB select 
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSeller();
		} else {
			seller = sellerBO.getSellerById(id);
		}
		
		// model에 담기
		model.addAttribute("title", "판매자 정보");
		model.addAttribute("seller", seller);
		
		// 응답화면
		return "lesson04/sellerInfo";
	}
	
}
