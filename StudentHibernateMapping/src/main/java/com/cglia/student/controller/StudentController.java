package com.cglia.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.student.entity.StudentEntity;
import com.cglia.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveStudentDetails(@RequestBody StudentEntity student) {
		try {
			studentService.saveStudentDetails(student);
			return new ResponseEntity<>("Student saved successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/view/all")
	public List<StudentEntity> viewAllStudentDetails() {

		return studentService.getAllStudentDetails();
	}

	@GetMapping("/view/{studentId}")
	public StudentEntity viewStudentdetail(@PathVariable int studentId) {

		return studentService.getStudentdetail(studentId);
	}
	

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> removeStudent(@PathVariable int studentId) {
		try {
			studentService.deleteStudentRecord(studentId);
			return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/view/name/{name}")
	public StudentEntity getDetailsByName(@PathVariable String name)
	{
		return studentService.getDetailsUsingName(name);
	}

}
