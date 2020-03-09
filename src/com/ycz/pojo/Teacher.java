package com.ycz.pojo;

import java.io.Serializable;

public class Teacher extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String course;
	private String className;

	
	
	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Teacher() {

	}

	public Teacher(int id, String username, String password, String sex, 
			int age, String course, String className) {
		super(id, username, password, sex, age);
		this.course = course;
		this.className = className;
	}

	/**
	 * ÷ÿ–¥toString∑Ω∑®
	 */
	@Override
	public String toString() {
		return this.getId() + "\t" + this.getUsername() + "\t" + this.getPassword() 
		+ "\t" + this.getSex() + "\t" + this.getAge() + "\t" + course + "\t" + className;
	}
	
	public String toString2() {
		return this.getUsername() + "\t"   + this.getSex() 
		+ "\t" + this.getAge() + "\t" + className  + "\t" + course;
	}
	
	
	
}
