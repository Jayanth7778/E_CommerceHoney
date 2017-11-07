package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTestCase
{

	@Autowired
	static DBConfig context;

	@Autowired
	static SupplierDAO supplierDAO;
	@Autowired
	static Supplier supplier;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");

		supplier = (Supplier) context.getBean("supplier");

	}

	@Ignore
	@Test
	public void createSupplierTestCase()
	{
		supplier.setId("SP_Univercell");
		supplier.setName("Univercell Mobiles");
		supplier.setAddress("Vizag");

		boolean flag = supplierDAO.save(supplier);

		assertEquals("createSupplierTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateSupplierTestCase() 
	{
		supplier.setId("SP_Reliance");
		supplier.setName("Reliance Mobiles");
		supplier.setAddress("Bangalore");

		boolean flag = supplierDAO.update(supplier);

		assertEquals("updateSupplierTestCase", true, flag);

	}

	
	@Test
	public void listAllSupplierTestCase()
	{
		int actualSize = supplierDAO.list().size();
		assertEquals(1, actualSize);
	}

}
