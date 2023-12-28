package com.quiz.store.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.store.domain.Store;
import com.quiz.store.mapper.StoreMapper;



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
