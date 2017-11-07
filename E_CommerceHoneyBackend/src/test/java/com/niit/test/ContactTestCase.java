package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.ContactDAO;
import com.niit.model.Contact;

public class ContactTestCase
{

	@Autowired
	static DBConfig context;

	@Autowired
	static ContactDAO contactDAO;
	@Autowired
	static Contact contact;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize() 
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		contactDAO = (ContactDAO) context.getBean("contactDAO");

		contact = (Contact) context.getBean("contact");

	}

	@Ignore
	@Test
	public void createContactTestCase()
	{
		contact.setName("Anirudh Goud");
		contact.setEmail("anirudhgoud@gmail.com");
		contact.setContact("7416153884");
		contact.setMessage("Original : Wrong delivery");

		boolean flag = contactDAO.save(contact);

		assertEquals("createContactTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateContactTestCase()
	{

		boolean flag = contactDAO.delete(0);

		assertEquals("updateContactTestCase", true, flag);

	}

	@Ignore
	@Test
	public void listAllContactTestCase()
	{
		int actualSize = contactDAO.list().size();
		assertEquals(1, actualSize);
	}

}
