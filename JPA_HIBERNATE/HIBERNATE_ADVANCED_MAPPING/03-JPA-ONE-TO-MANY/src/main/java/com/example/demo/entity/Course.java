package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
//define our fields
//constructor
//tostring
//getter setter
//annotation field

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")
private int id;
@Column(name="title")
private String title;

//it willpoint to id in intsructor  class
@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
@JoinColumn(name="instructor_id")
private Instructor instructor;


public Course(String title) {
	super();
	this.title = title;
}





public Course() {
	super();
	// TODO Auto-generated constructor stub
}





@Override
public String toString() {
	return "Course [id=" + id + ", title=" + title + "]";
}





public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public Instructor getInstructor() {
	return instructor;
}


public void setInstructor(Instructor instructor) {
	this.instructor = instructor;
}


}
