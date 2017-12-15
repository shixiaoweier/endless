package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.Cart;
import com.dao.CartDao;

@Service
@Transactional
public class CartService {

	@Autowired
	private CartDao cartDao;
	
	public boolean addCart(Integer book_id, Integer user_id,String book_name,double price) {
		return cartDao.addCart(book_id,user_id,book_name,price);
	}

	public List<Cart> getMyCart(Integer user_id) {
		return cartDao.getMyCart(user_id);
	}

	public boolean deleteCartBook(Integer book_id) {
		return cartDao.deleteCartBook(book_id);
	}

	public boolean cleanCart(Integer user_id) {
		return cartDao.cleanCart(user_id);
	}

}
