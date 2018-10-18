package cn.itcast.hibernate.domain;

import java.util.Set;

public class Teacher {

	private int id;
	private String name;
	private Set<Student> teachers;
}
