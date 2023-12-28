package com.quiz.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.store.bo.StoreBO;
import com.quiz.store.domain.Store;


@Controller
@RequestMapping("/store")
public class StoreController {
	
	@Autowired private StoreBO storeBO;

	// url : http://localhost:8080/store/store-view
	@RequestMapping("/store-view")
	public String storeView(Model model) {
		
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		
		return "store/storeView";
	}
	
}
