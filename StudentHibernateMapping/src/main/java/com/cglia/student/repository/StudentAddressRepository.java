package com.cglia.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cglia.student.entity.StudentAddressEntity;

public interface StudentAddressRepository extends JpaRepository<StudentAddressEntity,Integer>{

}
