package com.indra.formacio;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;

import com.indra.formacio.model.Customer;

public class CustomerTest extends TestCase {
	
	public void testSettersAndGetters() throws ParseException {
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		Customer a = new Customer();
		a.setName("Federico");
		a.setSurname("Larcia Gorca");
		a.setPercentDate(sdf.parse("04/04/2016"));
		a.setPercentProduct(2.4f);
		
		assertEquals("Federico", a.getName());
		assertEquals("LARCIA GORCA", a.getSurname());
		assertEquals("Larcia Gorca, Federico", a.getWholeName());
		assertEquals(sdf.parse("04/04/2016"), a.getPercentDate());
		assertEquals(2.4f, a.getPercentProduct());
	}
	
	public void testCalculPercentatge(){
		Customer a = new Customer();
		a.setPercentProduct(25f);
		
		assertEquals(a.getPercentProduct(),100f/4);
		
	}
}
