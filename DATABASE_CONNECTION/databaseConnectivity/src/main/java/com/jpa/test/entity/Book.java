package com.jpa.test.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//BOOK ACT AS PARENT,MANAGE REFERENCE TO PARENT
@Entity
@Table(name="books")
public class Book {
	
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column(name="book_id")
	private int id;
	private String title;
	private String movie;
	
	//this mapping is unidirectional from book to author
	//All the operations will happen at same type.
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public Book(int id, String title, String movie, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.movie = movie;
		this.author = author;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	


}