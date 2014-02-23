package com.library.interfaces;

import java.util.List;
import com.library.models.Book;
import com.library.models.SearchParameters;

public interface ILibrayDataAccess {
	
	boolean insert(Book book);
	
	boolean update(Book book);
	
	List<Book> retrieve(String query);
	
	boolean delete(Book book);
	
	Book getBook(Long id);
	
	List<Book> search(SearchParameters searchParameters);

}
