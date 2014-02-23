package com.library.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.library.database.MySqlDatabaseAccess;
import com.library.factory.FactoryFacade;
import com.library.interfaces.ILibrayDataAccess;
import com.library.models.Book;

@Controller
@RequestMapping("/Libray")
public class LibraryController {
	
	@RequestMapping(value = "/addBook", method = RequestMethod.POST)
	public String printHello(@ModelAttribute("book") Book book, BindingResult result) {
		System.out.println(book);
		MySqlDatabaseAccess database = new MySqlDatabaseAccess(); 
		database.insert(book);
	    return "redirect:books";
	}
	
	@RequestMapping("/bookDetails")
	public ModelAndView bookDetails() {
		
		return new ModelAndView("bookDetails", "command", new Book());
	}
	
	@RequestMapping("/books")
	public ModelAndView showBooks() {
		ModelAndView model = new ModelAndView("books");
		ILibrayDataAccess dataAccess = FactoryFacade.getDataAccessObject();
		List<Book> books = dataAccess.retrieve("select b from Book b");
		model.addObject("listOfBooks", books);
		return model;
	}

}
