package com.learner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stuId;
	private String name;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public int getStuId() {
		return stuId;
	}

	public String getName() {
		return name;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", name=" + name + "]";
	}

}
