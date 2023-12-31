package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.quiz.lesson06.domain.BookMark;

@Mapper
public interface BookMarkMapper {

	public List<BookMark> selectBookMarkList();
	
	public void insertBookMark(
			@Param("name")String name, 
			@Param("url")String url);
	
	// input : url
	// output : List<BookMark> 
	public List<BookMark> selectBookmarkList(String url);
	
	public int deleteBookmarkById(int id);
	
}
