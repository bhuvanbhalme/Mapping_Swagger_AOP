package com.cglia.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student_result", catalog = "bhuvan")
public class StudentResultEntity {
	@Id
	@Column(name = "result_Id", unique = true, nullable = false)
	private int resultId;

	@Column(name = "math")
	private int math;
	@Column(name = "science")
	private int science;
	@Column(name = "english")
	private int english;

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getScience() {
		return science;
	}

	public void setScience(int science) {
		this.science = science;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	// Constructors, getters, and setters
}
