package com.capgemini.core.ess.servicetest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.core.ess.model.ESSDAO;
import com.capgemini.core.ess.model.ESSDAOImpl;

public class ESSJunitTest {

	static ESSDAO essDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		essDAO=new ESSDAOImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
		essDAO=null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void test() throws Exception
	{
	int employeeId=1011;
	int days=20;
	double salary=essDAO.calculateSalary(employeeId, days);
	assertNotNull(employeeId);
	assertTrue(days>0&&days<32);
	}

}
