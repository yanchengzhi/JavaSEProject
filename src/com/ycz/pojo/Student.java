package com.ycz.pojo;

import java.io.Serializable;

public class Student extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String major;//רҵ
	private String course;//�γ�
	private String className;//�༶
	private int score;//����
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
		
	//��дtoString����
	@Override
	public String toString() {
		return this.getId() + "\t" + this.getUsername() +"\t" + this.getPassword() + "\t"
				+ this.getSex() +"\t" + this.getAge() + "\t"  + className + "\t"
				+ major + "\t" + course + "\t  " + score;
	}
	
	public String toString2() {
		return this.getId() + "\t" + this.getUsername() + "\t"
				+ this.getSex() + "\t"  + className + "\t"
			    + course + "\t  " + score;
	}

}
