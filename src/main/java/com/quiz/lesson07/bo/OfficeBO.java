package com.quiz.lesson07.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.OfficeEntity;
import com.quiz.lesson07.repository.OfficeRepository;

@Service
public class OfficeBO {

	@Autowired
	private OfficeRepository officeRepository;
	
	public OfficeEntity addOffice(
			String name, String business
			, String scale, int headcount) {
		
		OfficeEntity office = OfficeEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build();
		
		return officeRepository.save(office);
		
	}
	
}
