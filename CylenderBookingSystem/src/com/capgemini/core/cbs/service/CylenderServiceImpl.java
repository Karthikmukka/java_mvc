package com.capgemini.core.cbs.service;

import java.util.List;

import com.capgemini.core.cbs.beans.Cylenders;
import com.capgemini.core.cbs.exceptions.CBSExceptions;
import com.capgemini.core.cbs.model.CylenderDAO;
import com.capgemini.core.cbs.model.CylenderDAOImpl;

public class CylenderServiceImpl implements CylenderService 
{	
	CylenderDAO cyl=new CylenderDAOImpl();
	public List<Cylenders> getAllData() throws CBSExceptions 
	{
		List<Cylenders> cylenders=cyl.getAllData();
		return cylenders;
		
	}

	
	public int bookCylender(String agencyName, int count) throws CBSExceptions {
		int newRefNo=cyl.bookCylender(agencyName, count);
		return newRefNo;
	}

}
