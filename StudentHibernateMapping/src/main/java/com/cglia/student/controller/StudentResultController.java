package com.cglia.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.student.entity.StudentResultEntity;
import com.cglia.student.service.StudentResultService;

@RestController
@RequestMapping("/student")
public class StudentResultController {

	private final StudentResultService studentResultService;

	@Autowired
	public StudentResultController(StudentResultService studentResultService) {
		this.studentResultService = studentResultService;
	}

	@GetMapping("/result/pass")
	public List<StudentResultEntity> passResult() {

		return studentResultService.getResultsWithTotalGreaterThan100();
	}
	
	@GetMapping("/result/fail")
	public List<StudentResultEntity> failResult() {

		return studentResultService.getResultsWithTotalLessThan100();
	}

}
