package com.library.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import com.library.interfaces.ILibrayDataAccess;
import com.library.models.Book;
import com.library.models.SearchParameters;

public class MySqlDatabaseAccess implements ILibrayDataAccess{

	 private static final String PERSISTENCE_UNIT_NAME = "books";
	 private static EntityManagerFactory factory;
	 EntityManager em;
	 
	 void initializeEntityManager(){
		 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		 em = factory.createEntityManager();
	 }
	 
	@Override
	public boolean insert(Book book) {
		boolean status;
		initializeEntityManager();
		try{
			EntityTransaction etx = em.getTransaction();
			etx.begin();
		    em.persist(book);
		    etx.commit();
		    status = true;
		} catch (PersistenceException ex) {
			System.out.println(ex.getLocalizedMessage());
			status = false;
		}finally{
			em.close();
		}
		return status;
	}

	@Override
	public boolean update(Book book) {
		boolean status;
		initializeEntityManager();
		try{
			EntityTransaction etx = em.getTransaction();
			etx.begin();
		    em.merge(book);
		    etx.commit();
		    status = true;
		} catch (PersistenceException ex) {
			System.out.println(ex.getLocalizedMessage());
			status = false;
		}finally{
			em.close();
		}
		return status;
	}

	@Override
	public List<Book> retrieve(String query) {
		initializeEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();
		Query q = em.createQuery(query);
	    List<Book> bookList = q.getResultList();
	    etx.commit();
	    em.close();
	    return bookList;
	}

	@Override
	public boolean delete(Book book) {
		boolean status;
		initializeEntityManager();
		try{
			Book deleteBook = em.find(Book.class, book.getId());
			EntityTransaction etx = em.getTransaction();
			etx.begin();
			em.remove(deleteBook);
			etx.commit();
			em.flush();
			status = true;
		}catch(PersistenceException ex) {
			System.out.println(ex.getLocalizedMessage());
			status = false;
		}
		finally{
			em.close();
		}
		return status;
	}

	@Override
	public List<Book> search(SearchParameters searchParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(Long id) {
		Book book = null;
		initializeEntityManager();
		try{
			book = em.find(Book.class, id);
		}catch(PersistenceException ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		finally{
			em.close();
		}
		return book;
	}

}
