package com.tarento.studentrest.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tarento.studentrest.dao.StudentRepo;
import com.tarento.studentrest.dao.StudentRepoImplements;
import com.tarento.studentrest.model.Student;





@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/studentData")
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

	@DeleteMapping("/delete/{name}")
	public void deleteStudent(@PathVariable("name") String name) {

		studentrepo.delete(name);

	}

	@GetMapping("/search/{name}")
	public @ResponseBody List<Student> searchStudents(@PathVariable("name") String name) {

		return studentrepo.findStudent(name);

	}
	
	
	
	private static final Logger logger = Logger.getLogger(StudentController.class.getName());
	@PostMapping("/upload")
	public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file) throws Exception {
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}
		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		logger.info("inputStream: " + inputStream);
		logger.info("originalName: " + originalName);
		logger.info("name: " + name);
		logger.info("contentType: " + contentType);
		logger.info("size: " + size);
		// Do processing with uploaded file data in Service layer
		return new ResponseEntity<String>(originalName, HttpStatus.OK);
	}
}
