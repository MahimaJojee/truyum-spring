package com.cognizant.truyum.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service("menuItemService")
//@Component("menuItemService")
public class MenuItemService implements MenuItemDao{
	
		private  MenuItemDao menuItemDao ;

		@Autowired
		public void setMenuItemDao(MenuItemDao menuItemDao) {
			this.menuItemDao = menuItemDao;
		}
		
		@Override
		public List<MenuItem> getMenuItemListAdmin() throws ClassNotFoundException, SQLException
		{
			//ApplicationContext ctx=new ClassPathXmlApplicationContext("truyum-spring/src/main/resources/spring-config.xml");
			//menuItemDao = (MenuItemDao) ctx.getBean("menuItems");
			List<MenuItem> menuItemListAdmin = menuItemDao.getMenuItemListAdmin();
			return menuItemListAdmin;
		}
		
		@Override
		public List<MenuItem> getMenuItemListCustomer() throws ClassNotFoundException, SQLException
		{
			
			List<MenuItem> menuItemListCustomer = menuItemDao.getMenuItemListCustomer();
			return menuItemListCustomer;
		}
		
		@Override
		public MenuItem getMenuItem(long menuItemId) throws ClassNotFoundException, SQLException {
			
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			return menuItem;
		}


		@Override
		public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, SQLException {
			menuItemDao.modifyMenuItem(menuItem);
			
		}

		
}
