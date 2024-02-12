package com.student.project1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="program")
public class Program {
	
	@Id
	@Column(name="programcode")
	private String programcode;
	
	@Column(name="programname")
	private String programname;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="fee")
	private double fee;
	
	public Program(){
		
	}

	public Program(String programcode, String programname, int duration, double fee) {
		super();
		this.programcode = programcode;
		this.programname = programname;
		this.duration = duration;
		this.fee = fee;
	}

	public String getProgramcode() {
		return programcode;
	}

	public void setProgramcode(String programcode) {
		this.programcode = programcode;
	}

	public String getProgramname() {
		return programname;
	}

	public void setProgramname(String programname) {
		this.programname = programname;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}
	

}
