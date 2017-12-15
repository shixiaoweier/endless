package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Book;
import com.bean.BookType;
import com.dao.BookDao;

@Service
@Transactional
public class BookService {
	@Autowired
	private BookDao bookDao;

	public List<Book> getAllBook() {
		System.out.println("BookService");
		return bookDao.getAllBook();
	}

	public boolean deleteBook(Integer book_id) {
		return bookDao.deleteBook(book_id);
	}

	public boolean updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	public Book selectById(Integer book_id) {
		return bookDao.selectById(book_id);
	}

	public List<Book> getHotBook() {
		return bookDao.getHotBook();
	}

	public List<Book> getNewBook() {
		return bookDao.getNewBook();
	}

	public List<Book> getBookByBookType(String type_name) {
		return bookDao.getBookByBookType(type_name);
	}

	public List<Book> getBookByBookId() {
		return bookDao.getBookByBookId();
	}

	public Book getBookById(Integer book_id) {
		return bookDao.getBookById(book_id);
	}

	public boolean addBook(Book book) {
		return bookDao.addBook(book);
	}

	public BookType getBookTypeById(Integer type_id) {
		
		return bookDao.getBookTypeById(type_id);
	}
	
	
}