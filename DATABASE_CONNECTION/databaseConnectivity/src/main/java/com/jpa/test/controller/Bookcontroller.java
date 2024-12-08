package com.jpa.test.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entity.Book;
import com.jpa.test.services.BookService;


@RestController
public class Bookcontroller {

	// @RequestMapping(value="/books", method = RequestMethod.GET)

	// creates object of bookservice and add in this class
	@Autowired
	private BookService bookservice;

	// GET ALL BOOKS HANDLER
	/*
	 * @GetMapping("/books")
	 * 
	 * @ResponseBody public List<Book> getBooks() { //Book book=new Book();
	 * //book.setId(213); //book.setAuthor("shiva"); //book.setTitle("dd");
	 * 
	 * return this.bookservice.getAllBooks(); }
	 */
	// DDING STATUS MESSAGE
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> list = bookservice.getAllBooks();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
		// DDING STATUS MESSAGE
	}

	// GET SINGLE BOOKS HANDLER
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
		// CHECK IF BOOK GOT IS NULL OR NOT

		Book book = bookservice.getBookById(id);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}

	// ADD NEW BOOKS HANDLER

	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookservice.addBook(book);
		return b;
	}
	// DELETE BOOKS HANDLER

	@DeleteMapping("books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deleteBook(bookId);
	}

	// UPDATE BOOKS HANDLER

	@PutMapping("books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
		this.bookservice.updateBook(book, bookId);
		return book;
	}

}
