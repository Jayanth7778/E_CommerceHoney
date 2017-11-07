package com.niit.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDAO;
import com.niit.model.Cart;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO
{

	@Autowired
	private SessionFactory sessionFactory;

	public CartDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	public boolean save(Cart cart)
	{
		try 
		{
			sessionFactory.getCurrentSession().save(cart);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public boolean update(Cart cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cart);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Cart> list(String userID)
	{
		return  sessionFactory.getCurrentSession().createQuery("from Cart where user_id=?").setString(0, userID).list();
	}

	public double getTotalAmount(String userID)
	{
		return (Double) sessionFactory.getCurrentSession().createQuery("select sum(price) from Cart where user_Id=?").setString(0, userID).uniqueResult();
	}

	public boolean delete(int id)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(getCartById(id));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public Cart getCartById(int id) 
	{
		
		return 	(Cart)  sessionFactory.getCurrentSession().createQuery("from Cart where id = ?").setInteger(0, id).uniqueResult();
	}

	public boolean deleteAllProductsInCart(String user_id)
	{
		try 
		{
			sessionFactory.getCurrentSession().createQuery("delete from Cart where user_id = ?").setString(0, user_id).executeUpdate();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

	

}
