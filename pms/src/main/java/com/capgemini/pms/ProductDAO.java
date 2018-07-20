package com.capgemini.pms;

import java.util.ArrayList;

public class ProductDAO 
{
	ArrayList<Product> products  = new ArrayList<Product>();
	
	public boolean addProduct( Product product )
	{
		if( product == null)
			throw new NullPointerException();
		
		if( product.getId() == 0 && product.getName() == null && product.getPrice() == 0.0f)
			throw new IllegalArgumentException();
		
		if( products.contains(product) )
			return false;
					
		products.add(product);		
		return true;
	}
	
	public Product getProduct( int id )
	{
		return null;
	}
}
