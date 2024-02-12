package com.student.project1.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project1.model.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Integer> {

}
