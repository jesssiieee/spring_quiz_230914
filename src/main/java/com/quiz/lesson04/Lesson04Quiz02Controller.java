package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.domain.Realtor;

@Controller
@RequestMapping("/lesson04/quiz02")
public class Lesson04Quiz02Controller {
	
	@Autowired
	private RealtorBO realtorBO;

	// 추가화면
	// url : http://localhost:8080/lesson04/quiz02/add-realtor-view
	@GetMapping("/add-realtor-view")
	public String addRealtorView() {
		return "lesson04/addRealtor";
	}
	
	// 방금가입된 학생 화면 & DB에 insert
	// url : http://localhost:8080/lesson04/quiz02/add-realtor
	@PostMapping("/add-realtor")
	public String addRealtor(
			@ModelAttribute Realtor realtor, 
			Model model) {
		
		// insert
		realtorBO.addRealtor(realtor);
		
		// 사용자 select
		int id = realtor.getId();
		
		// select by id
		realtorBO.getRealtorById(id);
		
		// Model 객체에 담는다
		model.addAttribute("realtor", realtor);
		
		// 화면 뿌리기
		return "lesson04/afterAddRealtor";
		
	}
	
	
	
}
