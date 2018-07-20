package com.capgemini.core.ess.view;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.core.ess.bean.Employee;
import com.capgemini.core.ess.exceptions.ESSException;
import com.capgemini.core.ess.service.ESSService;
import com.capgemini.core.ess.service.ESSServiceImpl;

public class Client 
{
	public static void main(String[] args) 
	{
		PropertyConfigurator.configure("log4j.properties");
		Employee employee=new Employee();
		ESSService employeeService=new ESSServiceImpl();
		try {
			employee=employeeService.viewEmployeeDetails(3430);
			System.out.println(employee);
		} catch (ESSException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		try {
			double salary=employeeService.calculateSalary(1011, 22);
			System.out.println("Salary :"+salary);
		} catch (ESSException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
}
