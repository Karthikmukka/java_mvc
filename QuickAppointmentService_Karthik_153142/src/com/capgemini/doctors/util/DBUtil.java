package com.capgemini.doctors.util;

import java.util.HashMap;

import java.util.Map;

import com.capgemini.doctors.bean.DoctorAppointment;


public class DBUtil 
{
	private Map<Integer,DoctorAppointment> appointments =new HashMap<Integer,DoctorAppointment>();

	public Map<Integer, DoctorAppointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Map<Integer, DoctorAppointment> appointments) {
		this.appointments = appointments;
	}

	
}
