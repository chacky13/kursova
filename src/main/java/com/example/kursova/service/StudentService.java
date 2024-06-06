package com.example.kursova.service;

import java.util.List;

import com.example.kursova.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);
	public List<Student> getStudentsByLastName(String lastName);
}
