package com.capgemini.appointmentservice.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.dao.AppointmentServiceDAO;
import com.capgemini.appointmentservice.dao.AppointmentServiceDAOImpl;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;

public class AppointmentServiceServiceImpl implements AppointmentServiceService 
{
	private AppointmentServiceDAO appointmentServiceDAO;

	public AppointmentServiceServiceImpl() 
	{
		appointmentServiceDAO = new AppointmentServiceDAOImpl();
	}

	@Override
	public int bookAppointment(Appointment appointment) throws AppointmentServiceException {
	
		int appointmentRequestStatus = 0;
		
		if( isValid( appointment ) == true)
			appointmentRequestStatus = appointmentServiceDAO.bookAppointment( appointment );
			
		return appointmentRequestStatus;
	}

	@Override
	public Appointment getAppointmentStatus(int appointmentRequetId) throws AppointmentServiceException {
	
		return appointmentServiceDAO.getAppointmentStatus( appointmentRequetId );
	}

	@Override
	public boolean isValid(Appointment appointment) throws AppointmentServiceException 
	{
		if( appointment == null)
			throw new AppointmentServiceException( "Appointment instance cannot be null" );
		
		if( appointment.getPatientName() == null || appointment.getPatientName().trim().isEmpty() )
			throw new AppointmentServiceException( "Patient Name Cannot be Empty" );
		
		if( appointment.getPhoneNumber() == 0 ||  isPhoneNumberInvalid( appointment.getPhoneNumber() ) )
			throw new AppointmentServiceException( "Phone Number is invalid" );
		
		if( appointment.getEmail() == null || isEmailInvalid( appointment.getEmail() ) )
			throw new AppointmentServiceException( "Email has to be a valid email" );
		
		if( !(appointment.getAge() > 1 && appointment.getAge() <= 120) )
			throw new AppointmentServiceException( "Age has to be between 1 to 120" );
		
		if( appointment.getGender() == null || isGenderInvalid( appointment.getGender() ) ) 
			throw new AppointmentServiceException( "Gender can only be Male or Female" );
		
		if( appointment.getProblem() == null ||  appointment.getProblem().trim().isEmpty() )
			throw new AppointmentServiceException( "Problem cannot be blank" );
		
		if( appointment.getDate() == null ||  isDateInvalid( appointment.getDate() ) )
			throw new AppointmentServiceException( "AppointmentRequest date has to be greater then current date" );
		
		return true;
	}
	
	public boolean isDateInvalid(Date date) 
	{
		if( date.compareTo( new Date() ) <= 0)
			return true;
		else
			return false;
	}

	public static boolean isGenderInvalid(String gender) 
	{
		gender = gender.toLowerCase();
		
		if( !gender.matches("^male$|^female$"))
			return true;	
		else
			return false;
	}
	
	public boolean isEmailInvalid( String email ) {
		
		if( email.matches(".+\\@.+\\..+") ) 
		{
			return false;
		}		
		else 
			return true;
	}

	public static boolean isPhoneNumberInvalid( long phoneNumber )
	{
		if(String.valueOf(phoneNumber).matches("[1-9][0-9]{9}")) 
		{
			return false;
		}		
		else 
			return true;
	}
	
	public Date getDateFromString( String dateInString )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(dateInString , formatter);

		java.util.Date date = java.sql.Date.valueOf( localDate );

		return date;
	}

	
	
	
	@Override
	public void exitApplication() {
		appointmentServiceDAO.exitApplication();
	}
}
