package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.CartDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Cart;
import com.niit.model.Product;

public class CartTestCase 
{

	@Autowired
	static DBConfig context;

	@Autowired
	Product product;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	static CartDAO cartDAO;
	@Autowired
	static Cart cart;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		cartDAO =  (CartDAO) context.getBean("cartDAO");
		
		cart = (Cart)context.getBean("cart");
		
	}
	
	
	@Test
	public void createCartTestCase() 
	{


		cart.setUser_id("Anirudh");
		cart.setPrice(15000);
		cart.setProduct_name("Moto G5 Plus");
		
		boolean flag = cartDAO.save(cart);
		
		assertEquals("createCartTestCase",true,flag);
	}
	
	@Ignore
	@Test
	public void deleteCartTestCase()
	{
		boolean flag = cartDAO.deleteAllProductsInCart("Kiran");
		
		assertEquals(true, flag);
	}
	

}