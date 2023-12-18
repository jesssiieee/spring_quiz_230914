package com.quiz.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.EstateBO;
import com.quiz.lesson03.domain.Estate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {

	@Autowired EstateBO estateBO;
	
	// url : http://localhost:8080/lesson03/quiz01/1?id=20
	@RequestMapping("/1")
	public Estate quiz01_1(
			@RequestParam("id") int id ) {
		return estateBO.getEstate(id);
	}
	
	// url : http://localhost:8080/lesson03/quiz01/2?rent_price=90
	@RequestMapping("/2")
	public List<Estate> quiz01_2(
			@RequestParam("rent_price") int rent_price) {
		return (List<Estate>) estateBO.getEstateListByRent(rent_price);
	}
	
	// url : http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<Estate> quiz01_3 (
			@RequestParam(value = "area") int area, 
			@RequestParam(value = "price") int price ) {
		return (List<Estate>) estateBO.getEstateListAreaPrice(area, price);
	}
	
}
