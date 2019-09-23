package com.tarento.studentrest.model;

import org.springframework.data.annotation.Id;

public class Student {

	@Id
	private Integer studentId;
	private String name;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + "]";
	}

}
