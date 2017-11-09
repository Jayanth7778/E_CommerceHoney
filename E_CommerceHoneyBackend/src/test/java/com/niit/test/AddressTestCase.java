package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.AddressDAO;
import com.niit.model.Address;

public class AddressTestCase
{

	@Autowired
	static DBConfig context;

	@Autowired
	static AddressDAO addressDAO;

	@Autowired
	static Address address;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		addressDAO = (AddressDAO) context.getBean("addressDAO");

		address = (Address) context.getBean("address");

	}

	@Ignore
	@Test
	public void createAddressTestCase()
	 {
		address.setId("AniAddress");
		address.setUser_id("Anirudh");
		address.setH_no("4-1-185");
		address.setStreet("6th Road");
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setPin("500079");

		boolean flag = addressDAO.save(address);

		assertEquals("createAddressTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateAddressTestCase()
	 {
		address.setId("RajAddress");
		address.setUser_id("Raju Goud");
		address.setH_no("8-1-246");
		address.setStreet("Karmanghat Old Village");
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setPin("500079");

		boolean flag = addressDAO.update(address);

		assertEquals("createAddressTestCase", true, flag);

	}

	
	@Test
	public void listAllAddressTestCase()
	 {
		int actualSize = addressDAO.list().size();
		assertEquals(2, actualSize);
	} 

}
