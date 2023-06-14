package com.cglia.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cglia.student.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {

	StudentEntity findByName(String name);
}
