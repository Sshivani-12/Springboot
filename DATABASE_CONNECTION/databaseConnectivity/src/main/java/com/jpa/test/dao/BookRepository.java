package com.jpa.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.test.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findBy(int id);
}
