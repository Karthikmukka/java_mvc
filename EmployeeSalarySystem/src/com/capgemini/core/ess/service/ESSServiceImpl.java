package com.capgemini.core.ess.service;

import com.capgemini.core.ess.bean.Employee;
import com.capgemini.core.ess.exceptions.ESSException;
import com.capgemini.core.ess.model.ESSDAO;
import com.capgemini.core.ess.model.ESSDAOImpl;

public class ESSServiceImpl implements ESSService {

	ESSDAO employeeDAO=new ESSDAOImpl();
	@Override
	public Employee viewEmployeeDetails(int employeeId) throws ESSException 
	{
		
		 
		 
		Employee employee=employeeDAO.viewEmployeeDetails(employeeId);
		 
		return employee;
	}

	@Override
	public double calculateSalary(int employeeId, int days) throws ESSException 
	{
		double salary=employeeDAO.calculateSalary(employeeId, days);
		return salary;
	}

	
	
}
