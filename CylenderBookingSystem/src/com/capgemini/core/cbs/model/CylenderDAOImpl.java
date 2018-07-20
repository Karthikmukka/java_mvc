package com.capgemini.core.cbs.model;

import java.util.List;

import com.capgemini.core.cbs.beans.Cylenders;
import com.capgemini.core.cbs.exceptions.CBSExceptions;
import com.capgemini.core.cbs.util.DBUtil;

public class CylenderDAOImpl implements CylenderDAO 
{
	DBUtil dbutil=new DBUtil();
	private int cylenderCount;
	private List<Cylenders> cylenders;
	private int newCount;
	int referenceNo=1000;
	Cylenders cylender=new Cylenders();
	public CylenderDAOImpl() 
	{

		cylenders=dbutil.getCylender();
	}
	
	public List<Cylenders> getAllData() throws CBSExceptions 
	{
		return cylenders;
	}

	public int bookCylender(String agencyName, int count) throws CBSExceptions 
	{
		//System.out.println(count);
		int index=cylenders.indexOf(new Cylenders(agencyName));
		if(index==-1)
		{
			throw new CBSExceptions("Enter correct agency name");
		}
		
		//cylender found...updating details
		cylenderCount =cylenders.get(index).getCount();
		
		if(cylenderCount>=count)
		{
			
			cylender=cylenders.get(index);
			newCount=cylenderCount-count;
			cylender.setCount(newCount);
			referenceNo++;
		}
		else
			System.out.println("Cylinders not available");
		
		return referenceNo;
	}

}
