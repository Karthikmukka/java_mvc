package com.capgemini.appointmentservice.dao;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;

public interface AppointmentServiceDAO 
{
	public int bookAppointment(Appointment appointment) throws AppointmentServiceException;
	public Appointment getAppointmentStatus( int appointmentRequetId) throws AppointmentServiceException;
	
	public void exitApplication();
}
