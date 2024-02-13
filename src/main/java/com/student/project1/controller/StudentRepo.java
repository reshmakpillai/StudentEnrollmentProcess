package com.student.project1.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project1.model.Student;
import java.util.List;


public interface StudentRepo extends JpaRepository<Student, Integer> {
	
	Student findByUsername(String username);

}
