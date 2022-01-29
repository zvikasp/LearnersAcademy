package com.learner.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subId;
	private String name;
	
	@OneToOne
	@JoinColumn(name = "subId")
	private Teacher teacher;

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(String name) {
		super();
		this.name = name;
	}

	public int getSubId() {
		return subId;
	}

	public String getName() {
		return name;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Subject [subId=" + subId + ", name=" + name + "]";
	}
}
