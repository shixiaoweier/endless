package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private int book_id;
	
	@Column(name="book_name")
	private String book_name;
	
	@Column(name="book_auth")
	private String book_auth;
	
	@Column(name="book_price")
	private double book_price;
	
	
	@ManyToOne
	@JoinColumn(name="TYPE_ID")//指明Book表中的外键type_id
	//hibernate中放在getter方法中，结合spring时最好放在上面
	private BookType bookType;


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public String getBook_name() {
		return book_name;
	}


	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}


	public String getBook_auth() {
		return book_auth;
	}


	public void setBook_auth(String book_auth) {
		this.book_auth = book_auth;
	}


	public double getBook_price() {
		return book_price;
	}


	public void setBook_price(double book_price) {
		this.book_price = book_price;
	}


	public BookType getBookType() {
		return bookType;
	}


	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	

	
	
}