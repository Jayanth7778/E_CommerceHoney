package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO
{
	
	public boolean save(Cart cart);

	public boolean update(Cart cart);
	
	public boolean delete(int id);
	
	public boolean deleteAllProductsInCart(String user_id);

	public List<Cart> list(String userID);
	
	public double getTotalAmount(String userID);
	
	public Cart getCartById(int id);

}
