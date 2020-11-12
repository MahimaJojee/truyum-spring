package com.cognizant.truyum.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

public class CartService implements CartDao {

	@Autowired
	CartDao cartdao;

	public CartDao getCartdao() {
		return cartdao;
	}

	public void setCartdao(CartDao cartdao) {
		this.cartdao = cartdao;
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws ClassNotFoundException, SQLException {
		cartdao.addCartItem(userId, menuItemId);
	}
	
	@Override
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		
		return cartdao.getAllCartItems(userId);
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws ClassNotFoundException, SQLException {
	
		cartdao.removeCartItem(userId, menuItemId);
	}
	
	
	
}
