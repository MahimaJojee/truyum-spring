package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	
	public static void main(String args[]) throws CartEmptyException
	{
		testAddCartItem();
		testRemoveCartItem();
	}
	
	
	
	public static void testAddCartItem() throws CartEmptyException
	{
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		cartDao.addCartItem(1, 000001);
		cartDao.addCartItem(1, 000004);
		List<MenuItem> CartItemsList = cartDao.getAllCartItems(1);
		System.out.println("MenuItem list :" + CartItemsList);
		
		
	}
	public void testGetAllCartItems() throws CartEmptyException
	{
		CartDaoCollectionImpl cartDaoCollectionImpl = new CartDaoCollectionImpl();
		CartDao cartDao = cartDaoCollectionImpl;
		List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
		for(MenuItem cartItem:allCartItems)
			System.out.println(cartItem);
		
	}
	public static void testRemoveCartItem() throws CartEmptyException
	{
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 000004);
		List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
		System.out.println(allCartItems);
	}

}
