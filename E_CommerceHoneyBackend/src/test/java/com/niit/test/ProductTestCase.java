package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductTestCase
{

	@Autowired
	static DBConfig context;

	@Autowired
	static ProductDAO productDAO;
	@Autowired
	static Product product;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		productDAO =  (ProductDAO) context.getBean("productDAO");
		product = (Product)context.getBean("product");	
	}
	
	@Ignore
	@Test
	public void createProductTestCase()
	{
		product.setId("Apple");
		product.setCategory_id("Electronics");
		product.setDescription("iPhone 7 32GB black mobile phone online at best price");
		product.setName("Apple iPhone 7");
		product.setPrice(78599);
		product.setQuantity(10);
		product.setSupplier_id("SP_Reliance");
		
		assertTrue("Problem in Insertion",productDAO.save(product));
	}

	
	@Test
	public void updateProductTestCase()
	{
		product.setId("Moto");
		product.setName("Moto G4 Plus");
		product.setDescription("Brand new Moto G4 32gb black");
		product.setCategory_id("Electronics");
		product.setPrice(14999);
		product.setSupplier_id("SP_Sangeetha");
		product.setQuantity(4);
		
	}
	
	private void assertTrue(String string, boolean update) {
		// TODO Auto-generated method stub
		
	}

	@Ignore
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 
}
