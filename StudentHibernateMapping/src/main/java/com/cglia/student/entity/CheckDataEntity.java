package com.cglia.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Check_data")
public class CheckDataEntity {

	
	@Id
	@Column(name="student_id")
	private int  studentId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CheckDataEntity(int studentId, String name, String email) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
	}

	public CheckDataEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
