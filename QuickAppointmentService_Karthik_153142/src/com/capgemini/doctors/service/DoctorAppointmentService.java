package com.capgemini.doctors.service;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.dao.DoctorAppointmentDao;
import com.capgemini.doctors.dao.IDoctorAppointmentDao;
import com.capgemini.doctors.exceptions.QASException;

public class DoctorAppointmentService implements IDoctorAppointmentService 
{
	private IDoctorAppointmentDao doctorAppointmentDao;
	
	
	public DoctorAppointmentService() 
	{
		doctorAppointmentDao=new DoctorAppointmentDao();
	}
	
	

	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws QASException 
	{	
		int appointmentStatus =doctorAppointmentDao.addDoctorAppointmentDetails(doctorAppointment);
		return appointmentStatus;
	}

	@Override
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId) throws QASException 
	{
		return doctorAppointmentDao.getDoctorAppointmentDetails(appointmentId);
	}

}
