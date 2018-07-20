package com.capgemini.core.cbs.beans;

public class Cylenders 
{
	private String agencyName;
	private String location;
	private int count;
	


	public Cylenders() {
		super();
	}
	
	public Cylenders(String agencyName) {
		super();
		this.agencyName = agencyName;
	}

	public Cylenders(String agencyName, String location, int count) {
		super();
		this.agencyName = agencyName;
		this.location = location;
		this.count = count;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencyName == null) ? 0 : agencyName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylenders other = (Cylenders) obj;
		if (agencyName == null) {
			if (other.agencyName != null)
				return false;
		} else if (!agencyName.equals(other.agencyName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cylenders [agencyName=" + agencyName + ", location=" + location + ", count=" + count + "]";
	}


	
	
	
	
}
