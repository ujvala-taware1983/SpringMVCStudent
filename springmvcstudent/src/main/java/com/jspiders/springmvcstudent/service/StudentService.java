package com.jspiders.springmvcstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.springmvcstudent.pojo.StudentPOJO;
import com.jspiders.springmvcstudent.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;

	public StudentPOJO addStudent(String name, Long contact, String address, String course) {
		StudentPOJO student= repository.addStudent(name, contact, address, course);
		return student;
		
	}

	
	public StudentPOJO searchStudent(int id) {
		StudentPOJO student = repository.searchStudent(id);
		return student;
		
	}

	public List<StudentPOJO> searchAllStudents() {
		List<StudentPOJO> students = repository.searchAllStudents();
		return students;
	}


	public void removeStudent(int id) {
		repository.removeStudent(id);
		
	}


	public void updateStudent(int id, String name, long contact, String address, String course) {
		repository.updateStudent(id, name, contact, address, course);
		
	}


}
