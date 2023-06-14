package com.cglia.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cglia.student.entity.StudentProjectEntity;

public interface StudentProjectRepository extends JpaRepository<StudentProjectEntity,Integer>{
     
}
