package com.situ.hibernate.many2many;

import java.util.HashSet;
import java.util.Set;

public class Course {
	private Integer id;
	private String name;
	private Integer credit;
	private Set<Banji> banjis = new HashSet<>();

	public Integer getId() {
		return id;
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

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public Set<Banji> getBanjis() {
		return banjis;
	}

	public void setBanjis(Set<Banji> banjis) {
		this.banjis = banjis;
	}

}
