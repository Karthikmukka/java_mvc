package com.core.capgemini.lms.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.capgemini.lms.beans.Book;
import com.core.capgemini.lms.exceptions.LMSException;

public class LMSDAOImpl implements LMSDAO 
{
	Map<Integer,Book> books=new HashMap<>();
	private int bookIdValue=1000;
	
	public int generateBookId()
	{
		return ++bookIdValue;
	}
	
	//
	/*public int generateBookIdRND()
	{
		double rndDouble=Math.random();
		return (int)(rndDouble*10_000);
	}*/
	
	
	@Override
	public int addBook(Book book) throws LMSException 
	{
		book.setId(generateBookId());	/*increment*/ 
		//book.setId(generateBookIdRND());	\\random gen ID
		
		books.put(book.getId(), book);
		return book.getId();
	}

	@Override
	public Book getBook(int bookId) throws LMSException 
	{
		Book book=books.get(bookId);
		if(book==null)
		{
			throw new LMSException("Book not found with id: "+bookId);
		}
		
		return book;
	}

	@Override
	public void updateBook(Book book) throws LMSException 
	{
		if(books.containsKey(book.getId())==false)
			throw new LMSException("No book exists with this id, Hence Update failed");
		
		books.put(book.getId(),book);
	}

	@Override
	public Book removeBook(int bookId) throws LMSException 
	{
		Book book=books.remove(bookId);
		if(book==null)
			throw new LMSException("Remove book failed as no book found with given id");
		
		
		return book;
	}

	@Override
	public List<Book> getBooks() throws LMSException {
		
		return new ArrayList<Book>(books.values());
	}

}
