package com.cognizant.truyum.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemServiceTest {

    MenuItemService menuItemService;

    @Before
    public void initializeService() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("com.cognizant.truyum");
        context.refresh();
        menuItemService = context.getBean(MenuItemService.class);
    }

    @Test
    public void testGetMenuItemListAdminSize() throws ClassNotFoundException, SQLException {
        assertEquals(5, menuItemService.getMenuItemListAdmin().size());
    }

    @Test
    public void testGetMenuItemListAdminContainsSandwich() throws ClassNotFoundException, SQLException  {
        boolean hasSandwich = false;
        for (MenuItem item : menuItemService.getMenuItemListAdmin()) {
            if (item.getName().equalsIgnoreCase("Sandwich")) {
                hasSandwich = true;
                break;
            }
        }
        assertTrue(hasSandwich);
    }

    @Test
    public void testGetMenuItemListCustomerSize() {
        assertEquals(3, menuItemService.getMenuItemListCustomer().size());
    }

    @Test
    public void testGetMenuItemListCustomerNotContainsFrenchFries() {
        boolean hasSandwich = false;
        for (MenuItem item : menuItemService.getMenuItemListCustomer()) {
            if (item.getName().equalsIgnoreCase("French Fries")) {
                hasSandwich = true;
                break;
            }
        }
        assertFalse(hasSandwich);
    }

    @Test
    public void testGetMenuItem() {
        assertEquals(1, menuItemService.getMenuItem(1).getId());
    }

    @Test
    public void testModifyMenuItem() {
        assertFalse(150.0 == menuItemService.getMenuItem(1).getPrice());
        MenuItem modifieditem = new MenuItem(1, "Sandwich", 150, true, new Date(), "Main Course", false);
        menuItemService.editMenuItem(modifieditem);
        assertTrue(150.0 == menuItemService.getMenuItem(1).getPrice());
    }

    
    
    
    
}