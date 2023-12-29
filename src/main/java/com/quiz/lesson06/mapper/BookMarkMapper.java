package com.quiz.lesson06.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.domain.BookMark;

@Repository
public interface BookMarkMapper {

	public List<BookMark> selectBookMarkList();
	
	public void insertBookMark(
			@Param("name")String name, 
			@Param("url")String url);
	
}
