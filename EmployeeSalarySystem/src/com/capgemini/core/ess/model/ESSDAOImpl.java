package com.capgemini.core.ess.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.capgemini.core.ess.bean.Employee;
import com.capgemini.core.ess.exceptions.ESSException;
import com.capgemini.core.ess.util.DBUtil;

public class ESSDAOImpl implements ESSDAO 
{
	static Logger myLogger=Logger.getLogger(ESSDAOImpl.class);
	Employee employee1=new Employee(1011,"John","Security",600400);
	Employee employee2=new Employee(3433,"Eric","Accounts",400500);
	Employee employee3=new Employee(8734,"Peter","Accounts",500500);
	Employee employee4=new Employee(8732,"Anna","R&D",850300);
	Employee employee5=new Employee(8735,"Jane","Security",445000);
	
	DBUtil dbutil=new DBUtil();
	
	Map<Integer,Employee> mapping=new HashMap<Integer,Employee>();
	
	
	public ESSDAOImpl() 
	{
		mapping=dbutil.getMap();
		mapping.put(1011, employee1);
		mapping.put(3433, employee2);
		mapping.put(8734, employee3);
		mapping.put(8732, employee4);
		mapping.put(8735, employee5);
	}

	@Override
	public Employee viewEmployeeDetails(int employeeId) throws ESSException 
	{
		myLogger.info("You r in view details");
		/*System.out.println(employeeId);
		System.out.println(mapping);*/
		
		if(mapping.get(employeeId)==null)
		{
			myLogger.error("EMployee Not Found");
			throw new ESSException("EMployee Not Found");
		}
		else
		return mapping.get(employeeId);
	}

	@Override
	public double calculateSalary(int employeeId, int days) throws ESSException 
	{
		myLogger.info("You r in view details");
		if(mapping.get(employeeId)==null)
		{
			throw new ESSException("Employee Not Found");
		}
		else
		{
			Employee employee=mapping.get(employeeId);
			double salary=employee.getSalary();
			System.out.println(salary);
			double dailySalary=salary/365;
			double salaryForDays=dailySalary*days;
			return salaryForDays;
		}
		
	}

}
