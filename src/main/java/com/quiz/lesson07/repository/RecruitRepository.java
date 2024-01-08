package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{

	// 2. Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회
	public List<RecruitEntity> findByIdIn(List<Integer> id);
	
	// 3. 웹 back-end 개발자 이고 정규직인 공고를 조회
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
}
