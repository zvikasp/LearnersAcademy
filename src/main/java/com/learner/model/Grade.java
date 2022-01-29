package com.learner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clsId;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "clsId")
	private List<Student> students;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "clsId")
	private List<Subject> subjects;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "clsId")
	private List<Teacher> teachers;

	public Grade() {
		// TODO Auto-generated constructor stub
	}

	public Grade(String name) {
		super();
		this.name = name;
	}

	public int getClsId() {
		return clsId;
	}

	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setClsId(int clsId) {
		this.clsId = clsId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public String toString() {
		return "Class [clsId=" + clsId + ", name=" + name + "]";
	}	
}
