package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ContactDAO;
import com.niit.model.Contact;


@Repository("contactDAO")
@Transactional
public class ContactDAOImpl implements ContactDAO 
{
	
	@Autowired
	private SessionFactory sessionFactory;
		
	public ContactDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	public boolean save(Contact contact)
	{
		try
		{
			sessionFactory.getCurrentSession().save(contact);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}


	public boolean delete(int id)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(getContactById(id));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}


	@SuppressWarnings("unchecked")
	public List<Contact> list()
	{
		return  sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}


	public Contact getContactById(int id) 
	{

		return 	(Contact)  sessionFactory.getCurrentSession().get(Contact.class, id);
		
	}
	

}
