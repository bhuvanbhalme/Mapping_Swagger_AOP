package com.cglia.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglia.student.entity.StudentResultEntity;
import com.cglia.student.repository.StudentResultRepository;

@Service
public class StudentResultService {
    private final StudentResultRepository studentResultRepository;

    @Autowired
    public StudentResultService(StudentResultRepository studentResultRepository) {
        this.studentResultRepository = studentResultRepository;
    }

    public List<StudentResultEntity> getResultsWithTotalGreaterThan100() {
        return studentResultRepository.findResultsWithTotalGreaterThan100();
    }
    
    public List<StudentResultEntity> getResultsWithTotalLessThan100() {
        return studentResultRepository.findResultsWithTotalLessThan100();
    }
}
