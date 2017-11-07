package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.OrderTableDAO;
import com.niit.model.OrderTable;

public class OrderTableTestCase 
{

	@Autowired
	static DBConfig context;
	
	@Autowired
	static OrderTable orderTable;
	
	@Autowired
	static OrderTableDAO orderTableDAO;
	
	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		orderTableDAO =  (OrderTableDAO) context.getBean("orderTableDAO");
				
		orderTable = (OrderTable)context.getBean("orderTable");
		
	}
	
	
	@Ignore
	@Test
	public void createOrderTableTestCase()
	{
		orderTable.setId(1);
		orderTable.setUser_id("Anirudh");
		orderTable.setStatus("N");
		boolean flag = orderTableDAO.save(orderTable);
		
		assertEquals("createOrderTableTestCase", true, flag);
	}
	
	@Ignore
	@Test
	public void listTestCase()
	{
		int orderedSize = orderTableDAO.list("Kiran").size();
		assertEquals(1, orderedSize);
	}

}
