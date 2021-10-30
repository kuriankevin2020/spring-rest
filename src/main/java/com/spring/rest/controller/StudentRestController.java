package com.spring.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<Student>();

		students.add(new Student("Kurian", "Kevin"));
		students.add(new Student("Vineeth", "Neelan"));
		students.add(new Student("Deva", "Gopu"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentid}")
	public Student getStudent(@PathVariable int studentid) {

		if ((studentid >= students.size()) || (studentid < 0)) {
			throw new StudentNotFoundException("Student id not found - " + studentid);
		}

		return students.get(studentid);
	}

}
