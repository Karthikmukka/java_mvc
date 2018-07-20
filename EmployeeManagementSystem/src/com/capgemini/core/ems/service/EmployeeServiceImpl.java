package com.capgemini.core.ems.service;

import java.util.List;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSException;
import com.capgemini.core.ems.model.EmployeeDAO;
import com.capgemini.core.ems.model.EmployeeDAOImpl;

public class EmployeeServiceImpl implements EmployeeService {

	//loose coupling
	private EmployeeDAO empDAO;
	
	public EmployeeServiceImpl() 
	{
		//association - (link)
		empDAO = new EmployeeDAOImpl();
	}

	@Override
	public int addEmployee(Employee employee) throws EMSException {
		
		int empId = 0;
		
		if( isValid(employee) )
		{
			empDAO.startTransaction();
			empId = empDAO.addEmployee(employee);
			empDAO.commitTransaction();
		}
		return empId;
	}

	@Override
	public Employee getEmployee(int id) throws EMSException {
		
		Employee employee = null;
		empDAO.startTransaction();
		employee = empDAO.getEmployee(id);
		empDAO.commitTransaction();
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) throws EMSException 
	{
		empDAO.startTransaction();
		empDAO.updateEmployee( employee );
		empDAO.commitTransaction();
	}

	@Override
	public Employee removeEmployee(int id) throws EMSException 
	{
		Employee employee = null;
		empDAO.startTransaction();
		employee = empDAO.removeEmployee( id );
		empDAO.commitTransaction();
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws EMSException {
		
		List<Employee> employees = null;
		empDAO.startTransaction();
		employees = empDAO.getAllEmployees();
		empDAO.commitTransaction();
		return employees;
	}

	@Override
	public boolean isValid(Employee employee) throws EMSException {
		
		//validation code
		
		return true;
	}

}
