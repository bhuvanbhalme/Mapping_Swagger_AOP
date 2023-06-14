package com.cglia.student.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_information", catalog = "bhuvan")
public class StudentEntity {
	@Id
	@Column(name = "student_id", unique = true, nullable = false)
	private int studentId;

	@Column(name = "student_Name")
	private String name;
	@Column(name = "student_gender")
	private String gender;
	@Column(name = "student_email")
	private String email;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
	private List<StudentAddressEntity> addresses = new ArrayList<>();

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resultId")
	private StudentResultEntity result;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_project_table", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<StudentProjectEntity> projects = new ArrayList<>();

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentAddressEntity> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<StudentAddressEntity> addresses) {
		this.addresses = addresses;
	}

	public StudentResultEntity getResult() {
		return result;
	}

	public void setResult(StudentResultEntity result) {
		this.result = result;
	}

	public List<StudentProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<StudentProjectEntity> projects) {
		this.projects = projects;
	}

	// Constructors, getters, and setters
}
