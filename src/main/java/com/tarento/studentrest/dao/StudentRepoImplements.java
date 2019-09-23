package com.tarento.studentrest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mysql.cj.xdevapi.Statement;
import com.tarento.studentrest.StudentMapper;
import com.tarento.studentrest.model.Student;

@Repository

public class StudentRepoImplements implements StudentRepo {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public List<Student> allStudents() {
		String SQL = "select * from Student";
		List<Student> students = jdbctemplate.query(SQL, new StudentMapper());
		return students;
	}

	public int insertStudents(Student student) {

		String SQL = "insert into Student(studentId,name) values(?,?)";
		System.out.println(student);
		return jdbctemplate.update(SQL, student.getStudentId(), student.getName());
	}

	public void delete(Integer studentId) {
		String SQL = "delete  from Student where studentId = ?";
		jdbctemplate.update(SQL, studentId);
		System.out.println("Deleted");
	}

	public Student findStudentById(Integer studentId) {

		String FETCH_SQL_BY_ID = "select * from Student where studentId = ?";
		return jdbctemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { studentId }, new StudentMapper());

	}

}
