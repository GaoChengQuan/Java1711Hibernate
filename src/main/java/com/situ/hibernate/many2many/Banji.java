package com.situ.hibernate.many2many;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banji implements Serializable {
	private Integer id;
	private String name;
	// 使用set集合，表达一对多关系
	private Set<Student> students = new HashSet<>();
	private Set<Course> courses = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
