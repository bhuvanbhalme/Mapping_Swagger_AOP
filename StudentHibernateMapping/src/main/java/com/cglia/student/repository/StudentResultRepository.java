package com.cglia.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cglia.student.entity.StudentResultEntity;

public interface StudentResultRepository extends JpaRepository<StudentResultEntity,Integer>{
	@Query("SELECT sr FROM StudentResultEntity sr WHERE sr.math + sr.science + sr.english >= 100")
    List<StudentResultEntity> findResultsWithTotalGreaterThan100();
	
	@Query("SELECT sr FROM StudentResultEntity sr WHERE sr.math + sr.science + sr.english < 100")
    List<StudentResultEntity> findResultsWithTotalLessThan100();

}
