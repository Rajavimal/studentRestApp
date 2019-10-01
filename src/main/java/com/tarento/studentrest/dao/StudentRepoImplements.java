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
		
		try {
			
			String SQL = "select * from Student";
			List<Student> students = jdbctemplate.query(SQL, new StudentMapper());
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
		
	}

	public int insertStudents(Student student) {

		try {
			String SQL = "insert into Student(studentId,name,dept,email) values(?,?,?,?)";
			System.out.println(student);
			return jdbctemplate.update(SQL, student.getStudentId(), student.getName(), student.getDept(),
					student.getEmail());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return (Integer) null;
		
	}

	public void delete(String name) {
		
		try {
			String SQL = "delete  from Student where name = ?";
			jdbctemplate.update(SQL, name);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
	}

	public List<Student> findStudent(String name) {

		try {
			String SQL = "select * from Student where  studentId like '"+name+"%'  or name like  '"+name+"%'  or dept like  '"+name+"%'  or email like  '"+name+"%' ";
//			String n = name + "%";
			List<Student> students = jdbctemplate.query(SQL, new StudentMapper());
			return students;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
