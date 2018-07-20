package com.capgemini.core.ems.service;

import java.util.List;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSException;

public interface EmployeeService 
{
	public int addEmployee(Employee employee) throws EMSException;
	
	public Employee getEmployee( int id ) throws EMSException;
	
	public void updateEmployee( Employee employee ) throws EMSException;
	
	public Employee removeEmployee( int id ) throws EMSException;
	
	public List<Employee> getAllEmployees() throws EMSException;
	
	public boolean isValid( Employee employee ) throws EMSException;
}
