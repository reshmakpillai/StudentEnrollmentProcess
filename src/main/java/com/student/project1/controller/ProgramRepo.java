package com.student.project1.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.project1.model.Program;

public interface ProgramRepo extends JpaRepository<Program, String> {

}
