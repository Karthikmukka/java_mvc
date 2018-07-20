package com.capgemini.core.ess.service;

import com.capgemini.core.ess.bean.Employee;
import com.capgemini.core.ess.exceptions.ESSException;

public interface ESSService 
{
	public Employee viewEmployeeDetails(int employeeId) throws ESSException;
	public double calculateSalary(int employeeId,int days) throws ESSException;
}
