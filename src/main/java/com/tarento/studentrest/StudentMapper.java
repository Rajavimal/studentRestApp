package com.tarento.studentrest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tarento.studentrest.model.Student;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

		Student student = new Student();
		student.setStudentId(rs.getInt("studentId"));
		student.setName(rs.getString("name"));

		return student;
	}
}
