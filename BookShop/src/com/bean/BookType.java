package com.bean;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="book_type")
public class BookType {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="type_id")
	private int type_id;
	
	@Column(name="type_name")
	private String type_name;

	@OneToMany(mappedBy="bookType",targetEntity=com.bean.Book.class,cascade=CascadeType.ALL)
	private Set<Book> bookSet=new HashSet<Book>();
	
	
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	
	public Set<Book> getBookSet() {
		return bookSet;
	}
	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}
	
}