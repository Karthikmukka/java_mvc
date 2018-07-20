package com.core.capgemini.lms.view;

import com.core.capgemini.lms.beans.Book;
import com.core.capgemini.lms.exceptions.LMSException;
import com.core.capgemini.lms.model.LMSDAO;
import com.core.capgemini.lms.model.LMSDAOImpl;

public class Client 
{
	public static void main(String[] args) 
	{
		LMSDAO lmsDAO=new LMSDAOImpl();
		
		//add books
		
		Book book1=new Book("BasicJava","Amit",1200);
		Book book2=new Book("LearningPHP","Ravi",1100);
		
		
		
		try {
			lmsDAO.addBook(book1);
			lmsDAO.addBook(book2);
		}
		catch (LMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Get books
		
		try 
		{
			Book book3=lmsDAO.getBook(1001);
			Book book4=lmsDAO.getBook(1002);
			
			System.out.println(book3);
			System.out.println(book4);
		} catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
