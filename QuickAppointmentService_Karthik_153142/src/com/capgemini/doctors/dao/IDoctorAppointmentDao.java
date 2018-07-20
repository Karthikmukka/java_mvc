package com.capgemini.doctors.dao;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exceptions.QASException;

public interface IDoctorAppointmentDao
{
	int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws QASException;
	DoctorAppointment getDoctorAppointmentDetails(int appointmentId) throws QASException;
}
