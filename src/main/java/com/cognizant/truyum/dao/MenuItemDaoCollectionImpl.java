package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

@Component
@ImportResource("classpath:spring-config.xml")
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	@Autowired
	private List<MenuItem> menuItemList;


	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public MenuItemDaoCollectionImpl() {
		super();
	}

	public MenuItemDaoCollectionImpl(List<MenuItem> menuItemList) {
		super();
		this.menuItemList = menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	 public List<MenuItem> getMenuItemListCustomer() {
	        final List<MenuItem> customerItemList = new ArrayList<>();
	        final Date currDate = new Date();

	        for (final MenuItem item : menuItemList) {
	            if (item.isActive() && currDate.after(item.getDateOfLaunch())) {
	                customerItemList.add(item);
	            }
	        }
	        return customerItemList;
	    }


	    public void modifyMenuItem(final MenuItem menuItem) {

	        for (final MenuItem eachItem : menuItemList) {
	            if (menuItem.equals(eachItem)) {
	                eachItem.setId(menuItem.getId());
	                eachItem.setName(menuItem.getName());
	                eachItem.setPrice(menuItem.getPrice());
	                eachItem.setActive(menuItem.isActive());
	                eachItem.setDateOfLaunch(menuItem.getDateOfLaunch());
	                eachItem.setCategory(menuItem.getCategory());
	                eachItem.setFreeDelivery(menuItem.isFreeDelivery());
	                return;
	            }
	        }
	        menuItemList.add(menuItem);
	    }

	    
	    public MenuItem getMenuItem(final long menuItemId) {
	        MenuItem item = null;
	        for (final MenuItem menuItem : menuItemList) {
	            if (menuItem.getId() == menuItemId) {
	                item = menuItem;
	            }
	        }
	        return item;
	    }

}
