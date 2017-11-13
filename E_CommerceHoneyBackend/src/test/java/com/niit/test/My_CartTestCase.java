package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.My_CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.My_Cart;
import com.niit.model.Product;

public class My_CartTestCase
{

	@Autowired
	static AnnotationConfigApplicationContext context;

	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	static My_CartDAO my_CartDAO;
	@Autowired
	static My_Cart my_Cart;
	
	@BeforeClass
	public static void initialize()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the categoryDAO from context
		my_CartDAO =  (My_CartDAO) context.getBean("my_CartDAO");
		
		//get the category from context
		my_Cart = (My_Cart)context.getBean("my_Cart");
		
	}
	
	/*
	//@Test
	public void createCartTestCase() {
		my_Cart.setUser_id("Anirudh");
		my_Cart.setPrice(15000);
		my_Cart.setProduct_name("Moto G4 Plus");
		
		boolean flag = my_CartDAO.save(my_Cart);
		
		assertEquals("createCartTestCase",true,flag);
	}
	
	//@Test
	public void deleteCartTestCase(){
		boolean flag = my_CartDAO.deleteAllProductsInCart("Anirudh");
		
		assertEquals(true, flag);
	}
	
	@Test
	public void checkOutCartTestCase(){
		boolean flag = my_CartDAO.checkOut("myTest");
		assertEquals("checkOutCartTestCase", flag, true);
	}
	*/
}