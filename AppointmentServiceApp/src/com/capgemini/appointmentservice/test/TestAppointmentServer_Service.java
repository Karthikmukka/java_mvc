package com.capgemini.appointmentservice.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;
import com.capgemini.appointmentservice.service.AppointmentServiceService;
import com.capgemini.appointmentservice.service.AppointmentServiceServiceImpl;

public class TestAppointmentServer_Service {

	private static AppointmentServiceService appointmentService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		appointmentService = new AppointmentServiceServiceImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		appointmentService = null;
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBookAppointment() throws AppointmentServiceException 
	{
		Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(9898989898L);
		appointment.setEmail("eric@gmail.com");
		appointment.setGender("Male");
		appointment.setAge(32);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-12-2018") );
		
		
		int appointmentRequestId = appointmentService.bookAppointment( appointment );
		
		assertTrue( appointmentRequestId > 0 );
	}

	@Test
	public void testGetAppointmentStatus1() throws AppointmentServiceException 
	{
	Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(9898989898L);
		appointment.setEmail("eric@gmail.com");
		appointment.setGender("Male");
		appointment.setAge(32);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-12-2018") );
		
		int appointmentRequestId = appointmentService.bookAppointment( appointment );
		
		Appointment appointment2
		= appointmentService.getAppointmentStatus( appointmentRequestId );
		
		assertNotEquals(null, appointment2);
	}
	
	@Test(expected=AppointmentServiceException.class)
	public void testGetAppointmentStatus2() throws AppointmentServiceException 
	{
		Appointment appointment
		= appointmentService.getAppointmentStatus(-1000);
		
	}

	@Test(expected=AppointmentServiceException.class)
	public void testEmailValidation() throws AppointmentServiceException 
	{
	Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(9898989898L);
		appointment.setEmail("ericgmail.com");
		appointment.setGender("Male");
		appointment.setAge(32);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-12-2018") );
		
		appointmentService.bookAppointment( appointment );
	}
	
	@Test(expected=AppointmentServiceException.class)
	public void testAgeValidation() throws AppointmentServiceException 
	{
	Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(9898989898L);
		appointment.setEmail("ericgmail.com");
		appointment.setGender("Male");
		appointment.setAge(1000);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-12-2018") );
		
		appointmentService.bookAppointment( appointment );
	}
	
	@Test(expected=AppointmentServiceException.class)
	public void testPhoneValidation() throws AppointmentServiceException 
	{
	Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(8989L);
		appointment.setEmail("ericgmail.com");
		appointment.setGender("Male");
		appointment.setAge(32);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-12-2018") );
		
		appointmentService.bookAppointment( appointment );
	}
	
	@Test(expected=AppointmentServiceException.class)
	public void testGenderValidation() throws AppointmentServiceException 
	{
	Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(9898989898L);
		appointment.setEmail("ericgmail.com");
		appointment.setGender("Mle");
		appointment.setAge(32);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-12-2018") );
		
		appointmentService.bookAppointment( appointment );
	}
	
	@Test(expected=AppointmentServiceException.class)
	public void testDateValidation() throws AppointmentServiceException 
	{
	Appointment appointment = new Appointment();
		
		appointment.setPatientName("Eric");
		appointment.setPhoneNumber(9898989898L);
		appointment.setEmail("ericgmail.com");
		appointment.setGender("Male");
		appointment.setAge(32);
		appointment.setProblem("Heart");
		appointment.setDate( getDateFromString("04-05-2018") );
		
		appointmentService.bookAppointment( appointment );
	}
	public Date getDateFromString( String dateInString )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(dateInString , formatter);

		java.util.Date date = java.sql.Date.valueOf( localDate );

		return date;
	}

}
