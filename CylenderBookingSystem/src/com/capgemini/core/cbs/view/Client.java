package com.capgemini.core.cbs.view;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.core.cbs.beans.Cylenders;
import com.capgemini.core.cbs.exceptions.CBSExceptions;
import com.capgemini.core.cbs.service.CylenderService;
import com.capgemini.core.cbs.service.CylenderServiceImpl;
import com.sun.media.sound.SoftMixingSourceDataLine;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Client 
{
	
	CylenderService cs;
	
	public Client() 
	{
		cs=new CylenderServiceImpl();
	}

	public void menu()
	{
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Cylinder Booking System");
		System.out.println("1) Display Availability");
		System.out.println("2)Book Cylinders");
		System.out.println("3)Exit");
		System.out.println("Enter option: ");
		
		int option=sc.nextInt();
		switch (option) {
		case 1:
			try {
				List<Cylenders> cylenders=cs.getAllData();
				Iterator<Cylenders> it=cylenders.iterator();
				System.out.println("AgencyName \t Location \t Count");
				while(it.hasNext())
				{
				Cylenders cylender=it.next();
				System.out.println(cylender.getAgencyName()+"\t\t"+cylender.getLocation()+"\t\t"+cylender.getCount());
				} 
			}
			catch (CBSExceptions e) 
			{
				e.printStackTrace();
			}
			break;

		case 2:
			System.out.println("Enter Agency name and count");
			String aName=sc.next();
			int cnt=sc.nextInt();
			try {
				int referenceNo=cs.bookCylender(aName,cnt);
				List<Cylenders> cylenders=cs.getAllData();
				System.out.println("Booking Successful and ref No is "+referenceNo);
			} catch (CBSExceptions e) 
			{
				e.printStackTrace();
			}
			break;
		}
		
		
		
	}
	public static void main(String[] args) 
	{
		Client client=new Client();
		
		while(true)
			client.menu();
	}
}
