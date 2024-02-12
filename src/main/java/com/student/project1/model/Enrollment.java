package com.student.project1.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="enrollment")
public class Enrollment {
	
	@Id
	@Column(name="applicationno")
	private int applicationno;
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="programcode")
	private Program program;
	
	@Column(name="startdate")
	private LocalDate startdate;
	
	@Column(name="amountpaid")
    private double amountPaid;
	
	@Column(name="status")
    private String status;
	
	
	public Enrollment() {
		
	}
	

	public Enrollment(int applicationno, Student student, Program program, LocalDate startdate, double amountPaid,
			String status) {
		super();
		this.applicationno = applicationno;
		this.student = student;
		this.program = program;
		this.startdate = startdate;
		this.amountPaid = amountPaid;
		this.status = status;
	}


	public int getApplicationno() {
		return applicationno;
	}


	public void setApplicationno(int applicationno) {
		this.applicationno = applicationno;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public LocalDate getStartdate() {
		return startdate;
	}


	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}


	public double getAmountPaid() {
		return amountPaid;
	}


	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	

}
