package com.capgemini.appointmentservice.ui;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.appointmentservice.bean.Appointment;
import com.capgemini.appointmentservice.exception.AppointmentServiceException;
import com.capgemini.appointmentservice.service.AppointmentServiceService;
import com.capgemini.appointmentservice.service.AppointmentServiceServiceImpl;

interface MenuOptions
{
	public static final int BOOKDOCTORAPPOINTMENT = 1;
	public static final int VIEWDOCTORAPPOINTMENT = 2;
	public static final int EXITAPPLICATION = 3;
}

public class Client implements MenuOptions 
{
	private AppointmentServiceService appointmentServiceService;

	public Client() 
	{
		appointmentServiceService = new AppointmentServiceServiceImpl();
	}

	public void menu()
	{
		Scanner console = new Scanner( System.in );

		System.out.println("1) Book Doctor Appointment"); 
		System.out.println("2) View Doctor Appointment");
		System.out.println("3) Exit");

		System.out.print("\nEnter Your Choice: ");
		int choice = console.nextInt();
		
		operation( choice );

	}

	public void operation( int choice )
	{
		switch ( choice ) 
		{
		case BOOKDOCTORAPPOINTMENT: bookDoctorAppointment(); break;
		case VIEWDOCTORAPPOINTMENT: viewDoctorAppointment(); break;
		case EXITAPPLICATION: exitApplication(); break;

		default:
			break;
		}
	}

	private void bookDoctorAppointment() 
	{
		//Taking details from the User

		Scanner console = new Scanner( System.in );

		System.out.print("\n\nEnter Name of the Patient: ");
		String patientName = console.nextLine();

		System.out.print("Enter Phone Number: ");
		long phoneNumber = console.nextLong();

		System.out.print("Enter email: ");
		String email = console.next();

		System.out.print("Enter age: ");
		int age = console.nextInt();

		System.out.print("Enter gender: ");
		String gender = console.next();

		System.out.print("Enter Problem name: ");
		String problemName = console.next();

		System.out.print("Enter Appointment Date (dd/mm/yyyy): ");
		String appointmentRequestedDate = console.next();


		//Instantiating and initializing The Bean

		Appointment appointment = new Appointment();

		appointment.setPatientName( patientName );
		appointment.setPhoneNumber( phoneNumber );
		appointment.setEmail( email );
		appointment.setAge( age );
		appointment.setGender( gender );
		appointment.setProblem( problemName );
		appointment.setDate( getDateFromString( appointmentRequestedDate ) );

		//sending appointment request to service

		try 
		{
			int appointmentRequestId = appointmentServiceService.bookAppointment( appointment );
			
			System.out.println("\n\nYour Doctor Appointment has been successfully registered, your appointment ID is : "+ appointmentRequestId  + "\n\n");
		
		}
		catch (AppointmentServiceException e) 
		{
			//e.printStackTrace();
			System.out.println("Something went wrong. Reason: " + e.getMessage() );
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println("Something went wrong. Please try again after some time.");
		}
	}

	public Date getDateFromString( String dateInString )
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(dateInString , formatter);

		java.util.Date date = java.sql.Date.valueOf( localDate );

		return date;
	}


	private void viewDoctorAppointment() 
	{
		Scanner console = new Scanner( System.in );
		
		System.out.print("\n\nEnter the appointment Id: ");
		int appointmentRequestId = console.nextInt();
		
		try 
		{
			Appointment appointment = 
					appointmentServiceService.getAppointmentStatus( appointmentRequestId );
			
			System.out.println("\n\nPatient Name: " + appointment.getPatientName() );
			System.out.println("Appointment Status: " + appointment.getAppointmentStatus() );
			
			if( appointment.getAppointmentStatus().equalsIgnoreCase("DISAPPROVED") )
			{
				System.out.println("Doctor Name: ");
				System.out.println("Appointment Date: \n\n");
			}
			else
			{
				System.out.println("Doctor Name: " + appointment.getDoctorAssigned() );
				System.out.println("Appointment Date: " + appointment.getDate() );
				
				System.out.println("\n\nAppointment time, along with doctor’s phone number will be shared shortly with you.");
			}
			
		} 
		catch (AppointmentServiceException e) 
		{
			//e.printStackTrace();
			System.out.println("Something went wrong. Reason: " + e.getMessage() );
		}
		catch(Exception e)
		{
			//e.printStackTrace();
			System.out.println("Something went wrong. Please try again after some time.");
		}
	}

	private void exitApplication() {
		System.out.println("Thank you for using out Appointment Service Application");
		appointmentServiceService.exitApplication();
		System.exit( 0 );
	}

	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("log4j.properties");
		
		Client client = new Client();

		while(true)
			client.menu();
	}
}
