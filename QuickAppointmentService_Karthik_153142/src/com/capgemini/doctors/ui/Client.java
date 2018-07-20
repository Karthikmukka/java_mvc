package com.capgemini.doctors.ui;

import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.doctors.bean.DoctorAppointment;
import com.capgemini.doctors.exceptions.QASException;
import com.capgemini.doctors.service.DoctorAppointmentService;
import com.capgemini.doctors.service.IDoctorAppointmentService;

public class Client 
{
	private IDoctorAppointmentService doctorAppointmentService;
	Scanner console=new Scanner(System.in);
	public Client()
	{
		doctorAppointmentService=new DoctorAppointmentService();
	}
	
	public void menu() throws QASException
	{
		System.out.println("   _____________________________________________________________________");
		System.out.println("\tWhat can i do for you?");
		System.out.println("\t1)Book Doctor Appointment");
		System.out.println("\t2)View Appointment");
		System.out.println("\t3)Exit");
		System.out.println("   _____________________________________________________________________");
		int choice=console.nextInt();
		
		switch (choice) {
		case 1:
			DoctorAppointment doctorAppointment=new DoctorAppointment();
			System.out.print("\tEnter your Name    	 : ");
			doctorAppointment.setPatientName(console.next());
			System.out.print("\tEnter your PhoneNo	 : ");
			doctorAppointment.setPhoneNumber(console.next());
			System.out.print("\tEnter your Email   	 : ");
			doctorAppointment.setEmail(console.next());
			System.out.print("\tEnter your Age		 : ");
			doctorAppointment.setAge(console.nextInt());
			System.out.print("\tEnter your Gender 	 : ");
			doctorAppointment.setGender(console.next());
			System.out.print("\tEnter ProblemName        : ");
			doctorAppointment.setProblemName(console.next());
		//	System.out.print("Enter Appointment Date :\t");
			//patient.setAppointmentDate(console.next());
			int id=doctorAppointmentService.addDoctorAppointmentDetails(doctorAppointment);
			if(id!=-1)
			{
			System.out.println("\t**Your Doctor appointment has been successfully regestered**");
			System.out.println("\t**Application Id is: "+id+" **");
			}
			break;

		case 2:
			System.out.println("Enter Appointment Id");
			int appointmentId=console.nextInt();
			
			try
			{
				DoctorAppointment doctorAppointment1 = doctorAppointmentService.getDoctorAppointmentDetails(appointmentId);
			System.out.println("\tPatient Name 		: "+doctorAppointment1.getPatientName());
			System.out.println("\tAppointment Status  : "+doctorAppointment1.getAppointmentStatus());
			System.out.println("\tDoctor Name 		: "+doctorAppointment1.getDoctorName());
			if(doctorAppointment1.getDoctorName()!=null)
			{
				System.out.println("\tAppointment Date and Time along with doctor's phone number will be shared shortly with you");
			}
			}
			catch (QASException e) 
			{
				System.out.println(e.getMessage());
			}
			
			
			//System.out.println("Appointment Date :");
			break;
			
		case 3:
			System.out.println("GoodBye");
			System.exit(0);
			break;
		}
	}
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("log4j.properties");
		Client client =new Client();
		while(true)
		{
			try {
				client.menu();
			} catch (QASException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
