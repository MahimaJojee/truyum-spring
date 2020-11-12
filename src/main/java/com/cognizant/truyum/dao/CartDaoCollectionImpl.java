package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Component
@ImportResource("classpath:spring-config.xml")
public class CartDaoCollectionImpl implements CartDao {

	private HashMap<Long, Cart> userCarts;
	private Cart cart;

	/*
	public CartDaoCollectionImpl() {
		super();

		if (userCarts == null) {
			userCarts = new HashMap<Long, Cart>();
		}

	}
     */
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDaoCollectionImpl menuItemDaoCollectionImpl = new MenuItemDaoCollectionImpl();
		MenuItemDao menuItemDao = menuItemDaoCollectionImpl;

		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			Cart cart = userCarts.get(userId);
			List<MenuItem> menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);

		} else {
			List<MenuItem> menuItemList = new ArrayList<>();
			Cart new_cart = new Cart(menuItemList, menuItem.getPrice());
			menuItemList.add(menuItem);
			userCarts.put(userId, new_cart);
		}
	}

	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException {
		Cart cart = userCarts.get(userId);
		List<MenuItem> menuItemList = cart.getMenuItemList();

		double sum = 0;

		if (menuItemList == null || menuItemList.size() == 0) {
			throw new CartEmptyException();
		} else {
			for (MenuItem menuItem : menuItemList) {
				sum += menuItem.getPrice();
			}
			cart.setTotal(sum);
		}
		return cart.getMenuItemList();
	}

	public void removeCartItem(long userId, long menuItemId) {
		Cart cart = userCarts.get(userId);
		List<MenuItem> menuItemList = cart.getMenuItemList();

		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == userId)
				menuItemList.remove(menuItem);
		}
	}
}
