package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exceptions.QASException;

public interface IDoctorAppointmentService 
{
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws QASException;
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId) throws QASException;
}
