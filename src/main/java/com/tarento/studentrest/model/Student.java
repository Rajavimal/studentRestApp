package com.tarento.studentrest.model;

import org.springframework.data.annotation.Id;

public class Student {

	@Id
	private Integer studentId;
	private String name;
	private String dept;
	private String email;
	

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
		return "Student [studentId=" + studentId + ", name=" + name + ", dept=" + dept + ", email=" + email + "]";
	}

	

}
