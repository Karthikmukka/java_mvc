package com.capgemini.core.ess.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.core.ess.bean.Employee;

public class DBUtil 
{
	
	Map<Integer,Employee> mapping=new HashMap<Integer,Employee>();

	public Map<Integer, Employee> getMap() {
		return mapping;
	}

	public void setMap(Map<Integer, Employee> mapping) {
		this.mapping = mapping;
	}
	
	
	
	
}
