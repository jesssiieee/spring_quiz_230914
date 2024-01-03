package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/lesson06")
public class Lesson06Controller {

	@Autowired
	private BookMarkBO bookMarkBO;
	
	// 북마크 추가화면
	//url: http://localhost:8080/lesson06/add-bookmark
	@GetMapping("/add-bookmark")
	public String addBookmark() {
		return "lesson06/addBookmark";
	}
	
	// 입력 수행 - AJAX 통신 요청 => 응답값 JSON String
	@ResponseBody
	@PostMapping("/add-ing-bookmark")
	public Map<String, Object> ingAddBookmark (
		@RequestParam("name")String name, 
		@RequestParam("url")String url) {
		
		bookMarkBO.addBookMark(name, url);
		
		// "{"code": 200, "result":"성공"}"
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		
		return result; // map => JSON String
	}
	
	//url: http://localhost:8080/lesson06/after-add-bookmark
	@GetMapping("/after-add-bookmark")
	public String afterAddBookmark(
			Model model) {
		
		// get
		List<BookMark> bookmarklist = bookMarkBO.getBookMarkList();
		model.addAttribute("bookmarklist", bookmarklist);
		
		return "lesson06/afterBookmark";
	}
	
	// url 중복확인 ajax 통신 요청
	@ResponseBody
	@GetMapping("/is-duplication-url")
	public Map<String, Object> isDuplicationUrl (
			@RequestParam("url") String url ) {
		
		boolean isDuplication = bookMarkBO.isDuplicationByUrl(url);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200); // 성공
		result.put("is_duplication", isDuplication);
				
		
		return result;
	}
	
	// url 삭제
	@PostMapping("/delete-url")
	public Map<String, Object> idDeletePost(
			@RequestParam("id") int id ) {
		
		boolean deleteUrl = bookMarkBO.deleteUrlById(id);
		
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("delete_url", deleteUrl);
		
		return result;
		
	}
}
