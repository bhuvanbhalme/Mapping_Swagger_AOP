package com.cglia.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.cglia.student.entity.StudentAddressEntity;
import com.cglia.student.entity.StudentEntity;
import com.cglia.student.entity.StudentResultEntity;
import com.cglia.student.repository.StudentAddressRepository;
import com.cglia.student.repository.StudentRepository;
import com.cglia.student.repository.StudentResultRepository;

@Service
public class StudentService {

	private final StudentRepository studentRepository;
	private final StudentAddressRepository studentAddressRepository;
	private final StudentResultRepository studentResultRepository;
	
	public StudentService(StudentRepository studentRepository, StudentAddressRepository studentAddressRepository,
			StudentResultRepository studentResultRepository ) {
		this.studentRepository = studentRepository;
		this.studentAddressRepository = studentAddressRepository;
		this.studentResultRepository = studentResultRepository;
		
	}

	@Transactional(rollbackOn= {IllegalArgumentException.class})
	public void saveStudentDetails(StudentEntity student) {
		if (student == null || student.getResult() == null || isAnyFieldNull(student)) {
			throw new IllegalArgumentException("Invalid student details");
		}

		// Check if the result ID already exists
		StudentResultEntity existingResult = studentResultRepository.findById(student.getResult().getResultId())
				.orElse(null);
		if (existingResult != null) {
			throw new IllegalArgumentException("Result ID already exists");
		}

		List<StudentAddressEntity> addresses = student.getAddresses();

		for (StudentAddressEntity address : addresses) {
			address.setStudent(student);
			studentAddressRepository.save(address);
		}
		studentRepository.save(student);
	}

	private boolean isAnyFieldNull(StudentEntity student) {
		return student.getName() == null || student.getGender() == null || student.getEmail() == null
				|| student.getProjects() == null || student.getAddresses() == null || student.getAddresses().isEmpty();
	}

	
	
	
	public List<StudentEntity> getAllStudentDetails() {
		List<StudentEntity> students = studentRepository.findAll();
		   return students;	
	}

	public StudentEntity getStudentdetail(int studentId) {

		StudentEntity student = studentRepository.findById(studentId).get();
		return student;
	}

	public void deleteStudentRecord(int studentId) {
		StudentEntity student = studentRepository.findById(studentId).orElse(null);

		if (student != null) {
			// Delete the related records in the child tables first
			student.getProjects().clear(); // Remove all projects associated with the student

			// Then delete the student record
			studentRepository.delete(student);
		}
	}

	public StudentEntity getDetailsUsingName(String name) {
		StudentEntity student = studentRepository.findByName(name);
		return student;
	}

	
	
}
