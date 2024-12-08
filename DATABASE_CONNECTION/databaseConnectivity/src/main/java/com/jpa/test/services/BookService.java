package com.jpa.test.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jpa.test.dao.BookRepository;
import com.jpa.test.entity.Book;


@Service
public class BookService {
	
	// CONNECTING WITH DATABASE
	@Autowired
	private BookRepository bookrepository;

// get all books
	public List<Book> getAllBooks() {
	
		List<Book> list = (List<Book>) this.bookrepository.findAll();
		return list;
	}

	// get single book
	public Book getBookById(int id) {
		Book book = null;
		try {
			
			this.bookrepository.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

//ADD ONE BOOK
	public Book addBook(Book k) {
	
		Book result = this.bookrepository.save(k);
		return result;
	}

//DELETE ONE BOOK
	public void deleteBook(int bid) {
		
		this.bookrepository.deleteById(bid);
	}

	public void updateBook(Book book, int bookId) {
		
		this.bookrepository.save(book);
	}
}
