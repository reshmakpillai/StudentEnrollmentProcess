package com.student.project1.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project1.model.Program;

public interface ProgramRepo extends JpaRepository<Program, String> {
	
}
