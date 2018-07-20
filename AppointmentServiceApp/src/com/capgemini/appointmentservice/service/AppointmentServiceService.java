package com.capgemini.appointmentservice.service;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;

public interface AppointmentServiceService {

	public int bookAppointment(Appointment appointment) throws AppointmentServiceException;
	public Appointment getAppointmentStatus( int appointmentRequetId) throws AppointmentServiceException;
	public boolean isValid( Appointment appointment ) throws AppointmentServiceException;
	
	
	public void exitApplication();
}
