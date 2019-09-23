package com.tarento.studentrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tarento.studentrest.dao.StudentRepo;
import com.tarento.studentrest.dao.StudentRepoImplements;
import com.tarento.studentrest.model.Student;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vimal")
public class StudentController {

	@Autowired
	private StudentRepo studentrepo;

	@GetMapping("/displayall")
	public @ResponseBody List<Student> getAllStudents() {

		return studentrepo.allStudents();

	}

	@PostMapping("/post")
	public int setinsertStudents(@RequestBody Student student) {

		return studentrepo.insertStudents(student);

	}

	@DeleteMapping("/delete")
	public void deleteStudent(@RequestBody Integer studentId) {

		studentrepo.delete(studentId);

	}

	@GetMapping("/search")
	public @ResponseBody Student searchStudents(@RequestBody Integer studentId) {

		return studentrepo.findStudentById(studentId);

	}
}
