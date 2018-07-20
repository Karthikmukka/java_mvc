package com.capgemini.core.ems.model;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.capgemini.core.ems.beans.Employee;
import com.capgemini.core.ems.exceptions.EMSException;

import com.capgemini.core.ems.util.JPAUtil;


public class EmployeeDAOImpl implements EmployeeDAO
{
	private EntityManager entityManager;
	
	

	public EmployeeDAOImpl() 
	{
		entityManager=JPAUtil.getEntityManager();
	}

	@Override
	public int addEmployee(Employee employee) throws EMSException 
	{
		try {
			entityManager.persist(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee.getId();
	}

	@Override
	public Employee getEmployee(int id) throws EMSException 
	{
		 Employee employee=entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) throws EMSException {
		entityManager.merge(employee);

	}

	@Override
	public Employee removeEmployee(int id) throws EMSException {
		Employee employee=entityManager.find(Employee.class, id);
		entityManager.remove(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() throws EMSException 
	{
		Query query = entityManager.createNamedQuery("getAllEmployees");
		@SuppressWarnings("unchecked")
		List<Employee> employeeList = query.getResultList();
		return employeeList;
	}

	@Override
	public void startTransaction()
	{
		entityManager.getTransaction().begin();;

	}

	@Override
	public void commitTransaction() 
	{
		entityManager.getTransaction().commit();

	}


}
