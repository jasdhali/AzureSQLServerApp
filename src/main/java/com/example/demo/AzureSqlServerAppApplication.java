package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@SpringBootApplication
@RestController
@RequestMapping("/dbexplorer")
public class AzureSqlServerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureSqlServerAppApplication.class, args);
	}

	@Autowired
	private StudentRepo repo;
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return repo.save(student);
	}

	@GetMapping("/getData")
	public List<Student> getStudents() {
		return repo.findAll();
	}
}
