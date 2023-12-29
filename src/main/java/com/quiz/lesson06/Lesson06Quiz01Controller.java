package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookMarkBO;
import com.quiz.lesson06.domain.BookMark;

@Controller
@RequestMapping("/lesson06/quiz01")
public class Lesson06Quiz01Controller {

	@Autowired
	private BookMarkBO bookMarkBO;
	
	// 북마크 추가화면
	//url: http://localhost:8080/lesson06/quiz01/add-bookmark
	@GetMapping("/add-bookmark")
	public String addBookmark() {
		return "lesson06/addBookmark";
	}
	
	@ResponseBody
	@PostMapping("/add-ing-bookmark")
	public String ingAddBookmark (
		@RequestParam("name")String name, 
		@RequestParam("url")String url) {
		
		bookMarkBO.addBookMark(name, url);
		return "성공";
	}
	
	//url: http://localhost:8080/lesson06/quiz01/after-add-bookmark"
	@GetMapping("/after-add-bookmark")
	public String afterAddBookmark(
			Model model) {
		
		// get
		List<BookMark> bookmarklist = bookMarkBO.getBookMarkList();
		model.addAttribute("bookmarklist", bookmarklist);
		
		return "lesson06/afterBookmark";
	}
	
}
