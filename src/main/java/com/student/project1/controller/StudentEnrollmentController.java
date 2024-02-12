package com.student.project1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class StudentEnrollmentController {
	
	@Autowired
	private EnrollmentRepo emrollmentRepo;
	
	@Autowired
	private ProgramRepo programRepo;
	
	@Autowired
	private StudentRepo studentRepo;
	
	

}
