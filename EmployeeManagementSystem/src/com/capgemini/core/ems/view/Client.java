package com.capgemini.core.ems.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSException;
import com.capgemini.core.ems.service.EmployeeService;
import com.capgemini.core.ems.service.EmployeeServiceImpl;

public class Client 
{
	//loose coupling due to the use of interface reference
	private EmployeeService employeeService;

	public Client() {
		//association - linking to service
		employeeService = new EmployeeServiceImpl();
	}

	public void menu()
	{
		System.out.println("1) Add Employee Information");
		System.out.println("2) Get Employee Information");
		System.out.println("3) Update Employee Information");
		System.out.println("4) Remove Employee Information");
		System.out.println("5) View All Employee Information");
		System.out.println("0) Exit Application");

		Scanner console = new Scanner( System.in );

		System.out.println("\nPlease select an option:");
		int choice = console.nextInt();

		switch ( choice ) 
		{
		case 1:		

			System.out.println( "1) Enter Employee Name: " );				
			String name = console.next();

			System.out.println( "2) Enter Employee Salary: " );			
			double salary = console.nextDouble();

			System.out.println( "3) Enter Employee department: ");
			String department = console.next();

			System.out.println( "4) Enter Employee Date of Birth (dd-mm-yyyy): ");
			String dateOfBirthStr = console.next();

			System.out.println( "5) Enter Employee Date of Joining: (dd-mm-yyyy)" );
			String dateOfJoining = console.next();

			Employee employee = new Employee();

			employee.setName( name );
			employee.setSalary( salary );
			employee.setDepartment( department );
			employee.setDateOfBirth( convertToDate( dateOfBirthStr ) );
			employee.setDateOfJoining( convertToDate( dateOfJoining ) );

			try 
			{
				int empId = employeeService.addEmployee( employee );

				System.out.println("Employee added successfully. Employee ID: " + empId);
			} 
			catch (EMSException e) 
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}


			break;

		case 2:
			System.out.println("Enter Employee ID to view Details");
			int empId = console.nextInt();

			try 
			{
				employee = employeeService.getEmployee( empId );

				System.out.println("ID: " + employee.getId() );
				System.out.println("Name: " + employee.getName() );
				System.out.println("Salary: " + employee.getSalary() );
				System.out.println("Department: " + employee.getDepartment() );
				System.out.println("Date Of Birth: " + employee.getDateOfBirth() );
				System.out.println("Date of Joining: " + employee.getDateOfJoining() );
			} 
			catch (EMSException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			break;

		case 3:			
			
			//get employee details if exists
			
			System.out.println("Enter Employee ID to update Details");
			empId = console.nextInt();

			try 
			{
				employee = employeeService.getEmployee( empId );
				
				//updating name
				
				System.out.println("Employee name: " + employee.getName() );
				System.out.println("Do you want to update the name? (yes/no)");
				String reply = console.next();
				
				if( reply.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter New Name: ");
					employee.setName( console.next() );
				}
				
				//updating salary
				
				System.out.println("Employee salary: " + employee.getSalary() );
				System.out.println("Do you want to update the salary? (yes/no)");
				reply = console.next();
				
				if( reply.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter New Salary: ");
					employee.setSalary( console.nextDouble() );
				}
				
				//updating department
				
				System.out.println("Employee department: " + employee.getDepartment());
				System.out.println("Do you want to update the department? (yes/no)");
				reply = console.next();
				
				if( reply.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter New Department: ");
					employee.setDepartment( console.next() );
				}
				
				//updating Date of Birth
				
				System.out.println("Employee Date of Birth: " + employee.getDateOfBirth() );
				System.out.println("Do you want to update the Date of Birth? (yes/no)");
				reply = console.next();
				
				if( reply.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter New Date of Birth (dd-mm-yyyy): ");
					employee.setDateOfBirth( convertToDate( console.next() ) );
				}
				
				//updating Date of Joining
				
				System.out.println("Employee Date of Joining: " + employee.getDateOfJoining() );
				System.out.println("Do you want to update the Date of Joining? (yes/no)");
				reply = console.next();
				
				if( reply.equalsIgnoreCase("yes"))
				{
					System.out.println("Enter New Date of Joining (dd-mm-yyyy): ");
					employee.setDateOfJoining( convertToDate( console.next() ) );
				}
				
				employeeService.updateEmployee(employee);
				
				System.out.println("Employee details updated successfully...");


			} 
			catch (EMSException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			
			//update this employee;
			
			break;

		case 4:		

			System.out.println("Enter Employee ID to Delete Employee details");
			empId = console.nextInt();

			try 
			{
				employee = employeeService.removeEmployee( empId );

				System.out.println("Employee with below details removed:");
				System.out.println("ID: " + employee.getId() );
				System.out.println("Name: " + employee.getName() );
				System.out.println("Salary: " + employee.getSalary() );
				System.out.println("Department: " + employee.getDepartment() );
				System.out.println("Date Of Birth: " + employee.getDateOfBirth() );
				System.out.println("Date of Joining: " + employee.getDateOfJoining() );
			} 
			catch (EMSException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}


			break;

		case 5:		

			try 
			{
				List<Employee> employees = employeeService.getAllEmployees();

				Iterator<Employee> it = employees.iterator();

				System.out.println("ID \tName \t\tSalary \t\tDepartment \t\tDOB \t\tDOJ");

				while( it.hasNext() )
				{
					Employee emp = it.next();

					System.out.println( emp.getId() + "\t" +  
							emp.getName() + "\t" + 
							emp.getSalary() + "\t" + 
							emp.getDepartment() + "\t" + 
							emp.getDateOfBirth() + "\t" + 
							emp.getDateOfJoining());
				}

			} 
			catch (EMSException e) 
			{
				e.printStackTrace();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			break;

		case 0:
			System.out.println( "Goodbye" );
			System.exit( 0 );
			break;			

		default:
			System.out.println( "Invalid option." );
			break;
		}
	}

	public Date convertToDate(String dateInString)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate localDate = LocalDate.parse(dateInString , formatter);

		java.util.Date date = java.sql.Date.valueOf( localDate );

		return date;
	}

	public static void main(String[] args) 
	{
		Client client = new Client();

		//makes sure application runs forever unless you close it
		while(true)
			client.menu();
	}
}
