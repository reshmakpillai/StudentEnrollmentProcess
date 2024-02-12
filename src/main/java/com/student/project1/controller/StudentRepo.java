package com.student.project1.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project1.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
