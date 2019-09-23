package com.tarento.studentrest.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.tarento.studentrest.model.Student;

public interface StudentRepo {

	public List<Student> allStudents();

	public int insertStudents(Student student);

	public void delete(Integer studentId);

	public Student findStudentById(Integer studentId);
}
