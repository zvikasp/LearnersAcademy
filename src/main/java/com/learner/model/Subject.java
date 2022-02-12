package com.learner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String classId;

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String name, String classId) {
		super();
		this.name = name;
		this.classId = classId;
	}

	public Subject(int id, String name, String classId) {
		super();
		this.id = id;
		this.name = name;
		this.classId = classId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getClassId() {
		return classId;
	}

	public void setId(int subId) {
		this.id = subId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Subject [Id=" + id + ", name=" + name + "]";
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}
}
