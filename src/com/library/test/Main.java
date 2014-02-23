package com.library.test;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.library.database.MySqlDatabaseAccess;
import com.library.models.Book;

public class Main {
 
  public static void main(String[] args) {
    // read the existing entries and write to console
	  MySqlDatabaseAccess database = new MySqlDatabaseAccess();
    
    List<Book> bookList = database.retrieve("select b from Book b");
    for (Book book : bookList) {
      System.out.println(book);
    }
    System.out.println("Size: " + bookList.size());

//    Book book = new Book();
 //   book.setTitle("3  men");
 //   book.setDescription("This is a test");
 //   database.insert(book);
    Book updateBook = bookList.get(bookList.size()-4);
    updateBook.setTitle("10");
    System.out.println(updateBook);
    database.update(updateBook);
    Book deleteBook = bookList.get(3);
    
    database.delete(deleteBook);
    System.out.println(deleteBook);
    bookList = database.retrieve("select b from Book b");
    for (Book book1 : bookList) {
      System.out.println(book1);
    }
    System.out.println("Size: " + bookList.size());
    
    Book book2=database.getBook((long)22);
    System.out.println(book2);
    
  }
} 
