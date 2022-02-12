package com.learner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * User.java This is a model class represents a Grade entity
 *
 */

@Entity
public class Grade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "classId")
	private List<Student> students;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "classId")
	private List<Subject> subjects;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "classId")
	private List<Teacher> teachers;

	public Grade() {
		super();
	}

	public Grade(String name) {
		super();
		this.name = name;
	}

	public Grade(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
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

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

}