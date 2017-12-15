package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.Book;
import com.bean.BookType;
import com.service.BookService;

@Controller

public class BookController {
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/user/booklist")
	public String bookList(HttpSession session,Model model){
		System.out.println("BookContorller");
		List<Book> booklist=bookService.getAllBook();
		model.addAttribute("booklist",booklist);
		session.setAttribute("booklist", booklist);
		return "user/bookList";
	}
	
//	@RequestMapping("user/search")
//	public void searh(@RequestParam String search) {
//		if(search.contains("热")) {
//			hotBook();
//		}else if(search.contains("新")) {
//			newBook();
//		}else if(search.equals("类别ID")) {
//			getBookByBookType(search);
//		}
//		else if(search.equals("商品ID")) {
//			getBookByBookId();
//		}
//	}
	
	public String hotBook() {
		List<Book> bookList  = bookService.getHotBook();
		return "user/searchBook";
	}
	
	public String newBook() {
		List<Book> bookList  = bookService.getNewBook();
		return "user/searchBook";
	}
	
	public String getBookByBookType(String type_name) {
		List<Book> bookList  = bookService.getBookByBookType(type_name);
		return "user/searchBook";
	}
	
	public String getBookByBookId() {
		List<Book> bookList  = bookService.getBookByBookId();
		return "user/searchBook";
	}
	
	@RequestMapping("/admin/admin_booklist")
	public String admin_booklist(Model model) {
		List<Book> booklist=bookService.getAllBook();
		model.addAttribute("booklist",booklist);
		return "admin/admin_BookList";
		
	}
	
	@RequestMapping("/admin/admin_deleteBook")
	public String admin_deleteBook(Integer book_id) {
		System.out.println("要删除的书"+book_id);
		 boolean result=bookService.deleteBook(book_id);
		return "redirect:admin_booklist.action";
	}
	
	@RequestMapping("admin/admin_selectById")
	public String selectById(Integer book_id,Model model) {
		Book book=bookService.selectById(book_id);
		model.addAttribute("book",book);
		return "admin/admin_updateBook";
	}
	
	@RequestMapping("admin/updateBook")
	public String getBookInfo(Integer book_id,Model model) {
		//先查出来这个书的信息
		Book book=bookService.getBookById(book_id);
		System.out.println("要修改的书"+book.getBook_name()+book.getBook_price());
		model.addAttribute("book",book);
		return "admin/admin_updateBook";
	}
	
	@RequestMapping("admin/admin_updateBook")
	public String updateBook(@RequestParam Integer book_id,
							 @RequestParam String book_name,
							 @RequestParam double book_price,
							 @RequestParam String book_auth,
							 @RequestParam Integer type_id) {
		
		System.out.println("修改的内容"+book_name+"  "+type_id);

		//根据typeid找到bookType
		BookType bookType=bookService.getBookTypeById(type_id);
		
		Book book=new Book();
		book.setBook_id(book_id);
		book.setBook_name(book_name);
		book.setBook_auth(book_auth);
		book.setBook_price(book_price);
		book.setBookType(bookType);
		
		boolean result=bookService.updateBook(book);
		return "redirect:admin_booklist.action";
	}
	
	@RequestMapping("admin/admin_addBook")
	public String addBook( @RequestParam String book_name,
					 @RequestParam double book_price,
					 @RequestParam String book_auth,
					 @RequestParam Integer type_id) {
		
		//根据typeid找到bookType
				BookType bookType=bookService.getBookTypeById(type_id);
				
				Book book=new Book();
				book.setBook_name(book_name);
				book.setBook_auth(book_auth);
				book.setBook_price(book_price);
				book.setBookType(bookType);
		
		boolean result = bookService.addBook(book);
		return "redirect:admin_booklist.action";
	}
}