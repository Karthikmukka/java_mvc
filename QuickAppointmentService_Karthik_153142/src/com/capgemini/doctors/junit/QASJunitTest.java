package com.capgemini.doctors.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.DoctorAppointmentDao;
import com.capgemini.doctors.dao.IDoctorAppointmentDao;
import com.capgemini.doctors.exceptions.QASException;

public class QASJunitTest 
{

	static IDoctorAppointmentDao doctorAppointmentDao;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		doctorAppointmentDao=new DoctorAppointmentDao();
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		doctorAppointmentDao=null;
	}

	@Before
	public void setUp() throws Exception 
	{
		
	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test(expected=QASException.class)
	public void test2() throws QASException
	{
		int appointmentId=3783;
		DoctorAppointment doctorAppointment=doctorAppointmentDao.getDoctorAppointmentDetails(appointmentId);
		assertTrue(appointmentId!=-1);
	}

}
