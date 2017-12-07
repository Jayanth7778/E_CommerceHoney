package com.niit.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserTestCase
{

	@Autowired
	static DBConfig context;

	@Autowired
	static UserDAO userDAO;

	@Autowired
	static User user;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");

		user = (User) context.getBean("user");

	}

	@Ignore
 	@Test
	public void createUserTestCase()
	 {
		user.setId("Jayanth");
		user.setName("Jayanth");
		user.setPassword("Jayanth");
		user.setRole("ROLE_ADMIN");
		user.setContact("9676963891");
		boolean flag = userDAO.save(user);

		assertEquals("createUserTestCase", true, flag);

	}

	@Ignore
	@Test
	public void updateUserTestCase()
	{
		user.setId("Jayanth");
		user.setName("Jayanth");
		user.setPassword("Jayanth");
		user.setRole("ROLE_USER");
		user.setContact("9676963891");
		boolean flag = userDAO.update(user);

		assertEquals("updateUserTestCase", true, flag);

	}

	@Ignore
	@Test
	public void validateUserTestCase()
	 {

		boolean flag = userDAO.validate("Sainath", "Sainath");
		assertEquals(true, flag);

	}

	@Ignore
	@Test
	public void listAllUserTestCase()
	 {
		int actualSize = userDAO.list().size();
		assertEquals(3, actualSize);
	}

}
