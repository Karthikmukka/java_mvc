package com.capgemini.core.cbs.model;

import java.util.List;

import com.capgemini.core.cbs.beans.Cylenders;
import com.capgemini.core.cbs.exceptions.CBSExceptions;

public interface CylenderDAO 
{
	public List<Cylenders>getAllData() throws CBSExceptions;
	public int bookCylender(String agencyName,int count) throws CBSExceptions;
}
