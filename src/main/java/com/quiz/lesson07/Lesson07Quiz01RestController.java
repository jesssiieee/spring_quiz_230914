package com.quiz.lesson07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.bo.OfficeBO;
import com.quiz.lesson07.entity.OfficeEntity;

@RestController
@RequestMapping("/lesson07/quiz01")
public class Lesson07Quiz01RestController {

	@Autowired
	private OfficeBO officeBO;

	// url : http://localhost:8080/lesson07/quiz01/save1
	@GetMapping("/save1")
	public OfficeEntity create1() {

//		String name = "넥손";
//		String business = "컨텐츠 게임";
//		String scale = "대기업";
//		int headcount = 3585;

		return officeBO.addOffice("넥손", "컨텐츠 게임", "대기업", 3585);

	}

	// url : http://localhost:8080/lesson07/quiz01/save2
	@GetMapping("/save2")
	public OfficeEntity create2() {

//		String name = "버블팡";
//		String business = "여신 금융업";
//		String scale = "대기업";
//		int headcount = 6834;

		return officeBO.addOffice("버블팡", "여신 금융업", "대기업", 6834);

	}
	
	// url : http://localhost:8080/lesson07/quiz01/update
	@GetMapping("/update")
	public OfficeEntity update() {
		
		return officeBO.updateOfficeScaleHeadCountById(16, "중소기업", 34);
		
	}
	
	// url : http://localhost:8080/lesson07/quiz01/delete
	@GetMapping("/delete") 
	public String delete() {
		
		officeBO.deleteOfficeById(17);
		
		return "수행 완료";
	}

}
