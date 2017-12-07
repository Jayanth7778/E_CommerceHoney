package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDAO;
import com.niit.model.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	
	@Autowired
	private SessionFactory sessionFactory;
		
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	public boolean save(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().save(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Transactional
	public boolean update(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Transactional
	public boolean validate(String id, String password)
	{
		Query query=sessionFactory.getCurrentSession().createQuery(" from User where id = ? and password = ?");
		query.setString(0, id);    
		query.setString(1, password);
	
	 if(  query.uniqueResult()  == null)
	 {
		 return false;
	 }
	 else
	 {
		 return true;
	 }
	
	}

	/*@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<User> retrieveUser()
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		List<User> listUser=query.list();
		session.close();
		return listUser;
	} 
*/
	@Transactional
	public User get(String id)
	{
	  return (User) sessionFactory.getCurrentSession().get(User.class, id);
	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() 
	{

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User");
		List<User> listUser=query.list();
		session.close();
		return listUser;
	}

}
