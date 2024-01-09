package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quiz.lesson07.entity.RecruitEntity;

public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{

	// JPQL => Entity에 조회
	
	// 2. Request Parameter로 전달 받은 company id로 해당하는 회사의 공고를 조회
	public List<RecruitEntity> findByCompanyId(int companyId);
	
	// 3. 웹 back-end 개발자 이고 정규직인 공고를 조회
	public List<RecruitEntity> findByPositionAndType(String position, String type);
	
	// 4. 정규직이거나 연봉이 9000 이상인 공고를 조회
	public List<RecruitEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
	// 5. 계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개만 조회
	public List<RecruitEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// 6. 성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고를 조회
	public List<RecruitEntity> findByRegionAndSalaryBetween(String region, int salaryStart, int salaryEnd);
	
	// 7. 마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순으로 조회
	@Query(value="select * from `recruit` "
			+ "where `deadline` > :deadline and `salary` >= :salary and `type`= :type "
			+ "order by `salary` desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAndSalary(
			@Param("deadline") String deadline, 
			@Param("salary") int salary,
			@Param("type") String type );
	
}
