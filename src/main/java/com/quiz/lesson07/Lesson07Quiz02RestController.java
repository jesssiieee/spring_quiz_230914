package com.quiz.lesson07;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

	@Autowired
	private RecruitRepository recruitRepository; 
	
	// 1. id가 8인 공고를 조회
	// url : http://localhost:8080/lesson07/quiz02/1
	@RequestMapping("/1")
	public Optional<RecruitEntity> getRecruitList() {
		
		return recruitRepository.findById(8);
		
	}
	
	// 2. Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회
	// url : http://localhost:8080/lesson07/quiz02/2
	@RequestMapping("/2")
	public List<RecruitEntity> getRecruitListByIdIn() {
		
		return recruitRepository.findByIdIn(Arrays.asList(1, 2, 3));
		
	}
	
	// 3. 웹 back-end 개발자 이고 정규직인 공고를 조회
	// url : http://localhost:8080/lesson07/quiz02/3
	@RequestMapping("/3")
	public List<RecruitEntity> getRecruitListByPositionType() {
		
		return recruitRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
		
	}
	
	// 4. 정규직이거나 연봉이 9000 이상인 공고를 조회
	// url : http://localhost:8080/lesson07/quiz02/4
	// @RequestMapping("/4")
	// public List<RecruitEntity> getRecruitListByTypeSalary() {
		
		// return recruitRepository.findByTypeOrSalary("정규직", );
				
	// }
	
}
