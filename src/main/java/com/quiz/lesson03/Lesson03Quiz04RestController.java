package com.quiz.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;

@RestController
public class Lesson03Quiz04RestController {

	@Autowired
	private EstateBO estateBO;
	
	// http://localhost:8080/lesson03/quiz04/1?id=21
	@RequestMapping("/lesson03/quiz04/1")
	
	public String quiz04_1(
			@RequestParam("id")int id ) {
		int row = estateBO.deleteEstateById(id);
		return "삭제성공: " + row;
	}
	
}
