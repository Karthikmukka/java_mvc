package com.capgemini.core.cbs.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.core.cbs.beans.Cylenders;

public class DBUtil 
{
	private List<Cylenders> cylender=new ArrayList<Cylenders>();
	{
		cylender.add(new Cylenders("Jyoti","Mumbai",45));
		cylender.add(new Cylenders("HP","Pune",12));
		cylender.add(new Cylenders("NewHP","Chennai",34));
	}
	public List<Cylenders> getCylender() {
		return cylender;
	}
	public void setCylender(List<Cylenders> cylender) {
		this.cylender = cylender;
	}
	
	
}
