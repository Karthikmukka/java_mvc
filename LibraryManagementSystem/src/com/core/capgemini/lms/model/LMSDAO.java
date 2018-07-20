package com.core.capgemini.lms.model;

import java.util.List;

import com.core.capgemini.lms.beans.Book;
import com.core.capgemini.lms.exceptions.LMSException;

public interface LMSDAO 
{
	public int addBook(Book book) throws LMSException;
	public Book getBook(int bookId) throws LMSException;
	public void updateBook(Book book) throws LMSException;
	public Book removeBook(int bookId) throws LMSException;
	public List<Book> getBooks() throws LMSException;
}
