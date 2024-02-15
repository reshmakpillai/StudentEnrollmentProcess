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
	
	@Column(name="paymentdate")
	private LocalDate paymentdate;
	
	@Column(name="amountpaid")
    private double amountPaid;
	
	@Column(name="status")
    private int status;
	
	
	public Enrollment() {
		
	}


	public Enrollment(Student student, Program program, LocalDate paymentdate, double amountPaid, int status) {
		super();
		this.student = student;
		this.program = program;
		this.paymentdate = paymentdate;
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

	public LocalDate getpaymentdate() {
		return paymentdate;
	}


	public LocalDate setpaymentdate(LocalDate paymentdate) {
		return this.paymentdate = paymentdate;
	}


	public double getAmountPaid() {
		return amountPaid;
	}


	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	

}
