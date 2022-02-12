package com.learner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String classId;

	public Teacher() {
		super();
	}

	public Teacher(String name, String email, String classId) {
		super();
		this.name = name;
		this.email = email;
		this.classId = classId;
	}

	public Teacher(int id, String name, String email, String classId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getClassId() {
		return classId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
}
