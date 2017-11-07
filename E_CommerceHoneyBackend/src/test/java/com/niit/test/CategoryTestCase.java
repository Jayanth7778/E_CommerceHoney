package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryTestCase
{

	@Autowired
	static DBConfig context;

	@Autowired
	static CategoryDAO categoryDAO;

	@Autowired
	static Category category;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

		category = (Category) context.getBean("category");

	}

	@Ignore
	@Test
	public void createCategoryTestCase() 
	{
		category.setId("Electronics");
		category.setName("Mobiles");
		category.setDescription("This category contains Mobiles");

		boolean flag = categoryDAO.save(category);

		assertEquals("createCategoryTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateCategoryTestCase()
	 {
		category.setId("Mobiles");
		category.setName("Mobiles");
		category.setDescription("This category contains Mobiles under 10000");

		boolean flag = categoryDAO.update(category);

		assertEquals("updateCategoryTestCase", true, flag);

	}

	@Ignore
	@Test
	public void deleteCategoryTestCase()
	{
		category.setName("Mobiles1");
		boolean flag = categoryDAO.delete(category.getName());

		assertEquals("deleteCategoryTestCase", true, flag);

	}

	@Ignore
	@Test
	public void listAllCategoryTestCase()
	{
		int actualSize = categoryDAO.list().size();
		assertEquals(1, actualSize);
	}

}
