package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// in sql tables will be created automatically
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	// ANNOTATE THE CLASS AS AN ENTITY AND MAP TO DB TABLE
	// DEFINE THE FIELD
	// ANNOTATE THE FIELDS WITH DB COLUMN NAMES
	// CREATE CONSTRUCTORS
	// GENERATE GETTER/SETTER METHODS
	// GENERATE TOSTRING() METHOD



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id",nullable = false)
	private int id;

	@Column(name = "youtube_channel")
	private String youtubeChannel;

	@Column(name = "hobby")
	private String hobby;

	//ADD ONETOONE ANNOTATION
	//@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
	
	@OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;

	
	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby
				+ ", instructor=" + instructor + "]";
	}

	public InstructorDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstructorDetail(String youtubeChannel, String hobby, Instructor instructor) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
		this.instructor = instructor;
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	


}
