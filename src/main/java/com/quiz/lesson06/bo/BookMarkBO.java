package com.quiz.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.domain.BookMark;
import com.quiz.lesson06.mapper.BookMarkMapper;

@Service
public class BookMarkBO {

	@Autowired
	private BookMarkMapper bookMarkMapper;
	
	public List<BookMark> getBookMarkList() {
		return bookMarkMapper.selectBookMarkList();
	}
	
	public void addBookMark(String name, String url) {
		bookMarkMapper.insertBookMark(name, url);
	}
	
	// input: url
	// output: boolean
	public boolean isDuplicationByUrl(String url) {
		// 중복 없음 : [] => 비어있는 list
		// 중복 있음 : ["", ""] 채워져있는 리스트
		List<BookMark> bookmarkList = bookMarkMapper.selectBookmarkList(url);
		return bookmarkList.isEmpty() ? false : true;
		// return !bookmarkList.isEmpty();
	}
	
	public int deleteBookmarkById(int id) {
		return bookMarkMapper.deleteBookmarkById(id);
	}
	
}
