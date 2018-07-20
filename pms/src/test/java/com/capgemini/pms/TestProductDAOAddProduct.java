package com.capgemini.pms;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestProductDAOAddProduct {

	static ProductDAO productDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		productDAO = new ProductDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		productDAO = null;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test executing");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test executed");
	}

	//1st test case
	@Test(expected=NullPointerException.class)
	public void testAddProduct() 
	{
		productDAO.addProduct(null);
	}

	//2nd Test case
	@Test(expected=IllegalArgumentException.class)
	public void testAddProduct2() 
	{
		productDAO.addProduct(new Product());
	}

	//3rd Test case
	@Test
	public void testAddProduct3() 
	{

		Product product = new Product(101, "Sunglasses", 1200);

		boolean obtainedResult = productDAO.addProduct(product);
		boolean expectedResult = true;

		assertEquals(expectedResult, obtainedResult);
	}

	//4th Test case
	@Test
	public void testAddProduct4() 
	{
		Product product1 = new Product(101, "Sunglasses", 1200);
		Product product2 = new Product(101, "Sunglasses", 1200);
		
		productDAO.addProduct(product1);
		
		boolean obtainedResult = productDAO.addProduct(product2);
		boolean expectedResult = false;

		assertEquals(expectedResult, obtainedResult);
	}
}
















