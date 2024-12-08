package com.jpa.test.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.jpa.test.Book.Book;


@Component
public class BookService {
	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(12, "ss", "ABC"));
		list.add(new Book(13, "ss", "ABC"));
		list.add(new Book(14, "ss", "ABC"));

	}

// get all books
	public List<Book> getAllBooks() {
		return list;
	}
 //get single book
	public Book getBookById(int id) {
		Book book = null;
		try {
			list.stream().filter(e -> e.getId() == id).findFirst().get();
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

//ADD ONE BOOK
	public Book addBook(Book k) {
		list.add(k);
		return k;
	}

//DELETE ONE BOOK
	public Book deleteBook(int bid) {
		list = list.stream().filter(book -> {
			if (book.getId() != bid) {
				return true;
			}
			return false;
		}).collect(Collectors.toList());
		return null;
	}

	public void updateBook(Book book, int bookId) {
		list = list.stream().map(b -> {
			if (b.getId() == bookId) {
				b.setAuthor(book.getAuthor());
				b.setTitle(book.getTitle());

			}
			return b;
		}).collect(Collectors.toList());
	}
}

