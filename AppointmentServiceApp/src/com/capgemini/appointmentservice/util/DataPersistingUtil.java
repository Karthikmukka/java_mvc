package com.capgemini.appointmentservice.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;

public class DataPersistingUtil 
{
	private String path = "C:\\tmp\\appointments.dat";
	
	public void persistData( List<Appointment> appointments ) throws AppointmentServiceException
	{
		try(ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( path ))) 
		{
			
			oos.writeObject( appointments );
			
		} 
		catch (Exception e) 
		{
			throw new AppointmentServiceException("Could not load appointments. Please Contact the developer");
		}
	}
	
	public List<Appointment> retriveData() throws AppointmentServiceException
	{
		List<Appointment> appointments = null;
		
		try(ObjectInputStream oos = new ObjectInputStream( new FileInputStream( path ))) 
		{
			
			appointments = (List<Appointment>)oos.readObject();
			
		} 
		catch (Exception e) 
		{
			throw new AppointmentServiceException("Could not load appointments. Please Contact the developer");
		}		
		
		return appointments;
	}
}
