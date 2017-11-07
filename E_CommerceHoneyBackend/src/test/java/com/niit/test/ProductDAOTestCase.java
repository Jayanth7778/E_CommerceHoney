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

public class ProductDAOTestCase {

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
		
		product.setId("Moto_001");
		product.setCategory_id("Electronics");
		product.setDescription("Brand new Moto G4 32gb white");
		product.setName("Moto G4 Plus");
		product.setPrice(14499);
		product.setQuantity(1);
		product.setSupplier_id("SP_Reliance");
		
		boolean flag =  productDAO.saveOrUpdate(product);

		assertEquals("createProductTestCase",true,flag);
		
	}
	
	@Ignore
	@Test
	public void updateCategoryTestCase()
	{
		product.setId("Moto");
		product.setName("Moto G4 Plus");
		product.setDescription("Brand new Moto G4 32gb black");
		product.setCategory_id("Electronics");
		product.setPrice(14999);
		product.setSupplier_id("SP_Sangeetha");
		product.setQuantity(4);
		boolean flag = productDAO.saveOrUpdate(product);
		assertEquals("update Product TestCase",true,flag);
	}
	
	@Ignore
	@Test
	public void listAllProductTestCase()
	{
		int actualSize = productDAO.list().size();
		assertEquals(2, actualSize);
	} 
}
