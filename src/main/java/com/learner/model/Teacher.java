package com.learner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tId;
	private String name;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name) {
		super();
		this.name = name;
	}

	public int gettId() {
		return tId;
	}

	public String getName() {
		return name;
	}
	
	public void settId(int tId) {
		this.tId = tId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", name=" + name + "]";
	}
}
