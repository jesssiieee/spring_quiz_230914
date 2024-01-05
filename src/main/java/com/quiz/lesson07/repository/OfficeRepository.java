package com.quiz.lesson07.repository;

import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.OfficeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class OfficeRepository {

	@PersistenceContext
	private EntityManager em;
	
	public OfficeEntity save(OfficeEntity officeEntity) {
		em.persist(officeEntity);
		return officeEntity;
	}
	
}
