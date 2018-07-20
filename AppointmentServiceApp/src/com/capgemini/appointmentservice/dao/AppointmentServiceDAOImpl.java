package com.capgemini.appointmentservice.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;
import com.capgemini.appointmentservice.util.DataPersistingUtil;

import sun.security.krb5.internal.APOptions;

public class AppointmentServiceDAOImpl implements AppointmentServiceDAO 
{
	static Logger  myLogger = Logger.getLogger(AppointmentServiceDAOImpl.class);
	
	private DataPersistingUtil dataPersistingUtil  = new DataPersistingUtil();
	
	private List<Appointment> appointments = new ArrayList<Appointment>();
	private Map<String, String> doctorSpeciality  = new HashMap<String, String>();
	private int appointmentRequestId = 1000;
	
	{
		doctorSpeciality.put("Heart", "Dr. Brijesh Kumar");
		doctorSpeciality.put("Gynecology", "Dr. Sharda Singh");
		doctorSpeciality.put("Diabetes", "Dr. Heena Khan");
		doctorSpeciality.put("ENT", "Dr. Paras Mal");
		doctorSpeciality.put("Bone", "Dr. Renuka Kher");
		doctorSpeciality.put("Dermatology", "Dr. Kanika Kapoor");
		
		try 
		{
			appointments = dataPersistingUtil.retriveData();
			
			if( appointments == null )
				appointments = new ArrayList<Appointment>();
		} 
		catch (AppointmentServiceException e) 
		{
			//e.printStackTrace();
			//could not load the data
		}
	}
	
	public int generateAppointmentRequestId() {
		return ++appointmentRequestId;
	}
	
	@Override
	public int bookAppointment(Appointment appointment) throws AppointmentServiceException 
	{
		//set appointment request id
		appointment.setId( generateAppointmentRequestId() );
		
		
		//Below code checks if clinic has doctor of the requested speciality
		//if yes then assign and change status to approved
		String problem  = appointment.getProblem();
		
		if( doctorSpeciality.get(problem) != null )
		{
			
			appointment.setAppointmentStatus("Approved");
			appointment.setDoctorAssigned( doctorSpeciality.get(problem) );
		}
		
		//add appointment request irrespective of approval status
		appointments.add( appointment );
		
		return appointment.getId();
	}
	@Override
	public Appointment getAppointmentStatus(int appointmentRequetId) throws AppointmentServiceException {
		
		myLogger.info("getAppointmentStatus method called");
		
		Appointment appointment = null;
		
		int index = appointments.indexOf( new Appointment( appointmentRequetId ) );
		
		//check if appointment request exists
		if( index == -1 )
		{
			myLogger.error("Exception: Sorry No Appointment Request exists with id " + appointmentRequetId);
			throw new AppointmentServiceException("Sorry No Appointment Request exists with id " + appointmentRequetId);
		}
		
		//else get the appointment which exists
		appointment = appointments.get( index ); 
		
		return appointment;
	}
	
	public void exitApplication() {
		try 
		{
			dataPersistingUtil.persistData(appointments);
		} 
		catch (AppointmentServiceException e) 
		{
			//e.printStackTrace();
			//could not save the data
		}
	}
}
