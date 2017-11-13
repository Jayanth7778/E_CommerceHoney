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
	
	/*
	@Test
	public void createProductTestCase()
	{	
		product.setId("Apple");
		product.setName("Apple iPhone 7");
		product.setDescription("iPhone 7 32GB black mobile phone online at best price");
		product.setPrice(70000);
		product.setCategory_id("Electronics");
		product.setSupplier_id("Fedex");
		product.setQuantity(4);
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	
	@Ignore
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} */
	
}	