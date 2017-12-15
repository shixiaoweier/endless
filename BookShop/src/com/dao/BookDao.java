package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Book;
import com.bean.BookType;

@Repository
public class BookDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Book> getAllBook() {
		System.out.println("BookDao");
		Session session = sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Book");
		List<Book> bookList=query.list();
		return bookList;
	}

	public boolean deleteBook(Integer book_id) {
		Session session=sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("delete from Book where book_id=?");
		query.setParameter(0, book_id);
		int result=query.executeUpdate();

		
		return false;
	}

	public Book selectById(Integer book_id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Book where book_id=?");
		query.setParameter(0, book_id);
		Book book=(Book)query.uniqueResult();
		return book;
	}
	
	public boolean updateBook(Book book) {
		
		System.out.println("熟的类型id"+book.getBookType().getType_id());
		Session session=sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(book);
		
		return false;
	}

	public List<Book> getHotBook() {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from Book where book_id<?");
		query.setParameter(0, 5);
		List<Book> bookList=query.list();
		
		return bookList;
	}

	public List<Book> getNewBook() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_id>?");
		query.setParameter(0, 10);
		List<Book> bookList=query.list();
		return null;
	}

	public List<Book> getBookByBookType(String type_name) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("from BookType where type_name=?");
		query.setParameter(0,type_name );
		BookType bookType=(BookType) query.uniqueResult();
		
		Query query1 = session.createQuery("from Book where bookType=?");
		query.setParameter(0,bookType );
		List<Book> bookList=query.list();
		
		return bookList;
	}

	public List<Book> getBookByBookId() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_id=?");
		query.setParameter(0, 10);
		List<Book> bookList=query.list();
		return null;
	}

	public Book getBookById(Integer book_id) {
		System.out.println("要改的书"+book_id);
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Book where book_id=?");
		query.setParameter(0, book_id);
		Book book=(Book)query.uniqueResult();
		return book;
	}

	public boolean addBook(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.save(book);
		return false;
	}

	public BookType getBookTypeById(Integer type_id) {
		Session session = sessionFactory.getCurrentSession();
		BookType bookType=(BookType)session.get(BookType.class, type_id);
		return bookType;
	}

}











