package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.OfficeEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public interface OfficeRepository extends JpaRepository<OfficeEntity, Integer> {

	// Spring data JPA
	
	// Optional<Entity 객체> findById(id);
	
}
