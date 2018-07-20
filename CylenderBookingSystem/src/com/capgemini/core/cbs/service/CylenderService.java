package com.capgemini.core.cbs.service;

import java.util.List;

import com.capgemini.core.cbs.beans.Cylenders;
import com.capgemini.core.cbs.exceptions.CBSExceptions;

public interface CylenderService 
{
	public List<Cylenders>getAllData() throws CBSExceptions;
	public int bookCylender(String agencyName,int count) throws CBSExceptions;
}
