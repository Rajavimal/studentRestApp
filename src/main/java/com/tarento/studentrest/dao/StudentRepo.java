package com.tarento.studentrest.dao;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.multipart.MultipartFile;

import com.tarento.studentrest.model.Student;

public interface StudentRepo {

	public List<Student> allStudents();

	public int insertStudents(Student student);

	public void delete(String name);

	public List<Student> findStudent(String name);
	
	
	
	
}
