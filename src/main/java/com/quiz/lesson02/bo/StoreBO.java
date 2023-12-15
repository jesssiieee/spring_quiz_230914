package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // Spring Bean
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	
	// input : X
	// output : 컨트롤러에게 요청 -> List<Store> -> 컨트롤러에게 돌려준다
	
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
	
}
