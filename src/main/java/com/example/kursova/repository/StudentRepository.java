package com.example.kursova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.kursova.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long>{
    List<Student> findByLastName(String lastName);

}
