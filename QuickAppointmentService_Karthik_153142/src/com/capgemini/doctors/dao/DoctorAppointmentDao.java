package com.capgemini.doctors.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exceptions.QASException;
import com.capgemini.doctors.util.DBUtil;

public class DoctorAppointmentDao implements IDoctorAppointmentDao 
{
	static Logger myLogger=Logger.getLogger(DoctorAppointmentDao.class);
	private DBUtil dbutil=new DBUtil();
	
	private Map<Integer,DoctorAppointment> appointments =new HashMap<Integer,DoctorAppointment>();
	private Map<String, String> doctorSpeciality  = new HashMap<String, String>();
	{
		doctorSpeciality.put("Heart", "Dr. Brijesh Kumar");
		doctorSpeciality.put("Gynecology", "Dr. Sharda Singh");
		doctorSpeciality.put("Diabetes", "Dr. Heena Khan");
		doctorSpeciality.put("ENT", "Dr. Paras Mal");
		doctorSpeciality.put("Bone", "Dr. Renuka Kher");
		doctorSpeciality.put("Dermatology", "Dr. Kanika Kapoor");
	}
	
	private int appointmentRequestId = 1000;
	public int generateAppointmentId()
	{
		double rndDouble=Math.random();
		return (int)(rndDouble*10_000);
	}
	
	public DoctorAppointmentDao() 
	{
		appointments=dbutil.getAppointments();
	}
	
	
	
	
	

	@Override
	public int addDoctorAppointmentDetails(DoctorAppointment doctorAppointment) throws QASException 
	{
		myLogger.info("in addDoctorAppointmentDetails");
		doctorAppointment.setAppointmentId(generateAppointmentId());
		
		String problemName=doctorAppointment.getProblemName();
		
		if( doctorSpeciality.get(problemName) != null )
		{
			doctorAppointment.setAppointmentStatus("Approved");
			doctorAppointment.setDoctorName( doctorSpeciality.get(problemName) );
		}
		
		appointments.put(doctorAppointment.getAppointmentId(),doctorAppointment);
		
		return doctorAppointment.getAppointmentId();
	}

	@Override
	public DoctorAppointment getDoctorAppointmentDetails(int appointmentId) throws QASException 
	{
		myLogger.info("in getDoctorAppointmentDetails()");
		DoctorAppointment doctorAppointment=null;
		if(appointments.get(appointmentId)==null)
		{
			myLogger.error("Sorry appointment ID is incorrect");
			throw new QASException("Sorry appointment ID is incorrect");
		}
		else
		{
			doctorAppointment=appointments.get(appointmentId);
			
		}
			return doctorAppointment;
	}

}
