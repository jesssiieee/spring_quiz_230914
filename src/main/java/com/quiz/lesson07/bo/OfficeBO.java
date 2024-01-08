package com.quiz.lesson07.bo;

import java.util.Optional;

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
		
		return officeRepository.save(OfficeEntity.builder()
				.name(name)
				.business(business)
				.scale(scale)
				.headcount(headcount)
				.build()
		);
		
	}
	
	// update
	public OfficeEntity updateOfficeScaleHeadCountById(int id, String scale, int headcount) {
		
		OfficeEntity office = officeRepository.findById(id).orElse(null);
		
		if (office != null) {
			office = office.toBuilder()
					.scale(scale)
					.headcount(headcount)
					.build();
			
			// update - save()
			office = officeRepository.save(office);
			
		}
		
		return office;
		
	}
	
	// delete
	public void deleteOfficeById(int id) {
		
		Optional<OfficeEntity> officeOptional = officeRepository.findById(id);
		officeOptional.ifPresent(o -> officeRepository.delete(o));
		
	}
	
}
