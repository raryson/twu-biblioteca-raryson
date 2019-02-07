package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.MenuItemNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.services.MenuService;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuServiceTest {

    @Test
    public void whenUserNeedToViewMenu() {
        MenuService menuService = new MenuService();
        for(MenuItem menuItem : menuService.getMenuList()){
            String menuItemItered = menuItem.getName();
            MenuTypes menuTypeItered = menuItem.getOption();
            assertNotNull(menuItemItered);
            assertNotNull(menuTypeItered);
        }
    }

    @Test
    public void whenMenuAreShowedOnScreen() {
        final String expectedMenuMessage = "Please, select one of this options:\n\t0 - Exit\t1 - List All Books" +
                "\t2 - Checkout a Book\t3 - Checking a Book";
        MenuService menuService = new MenuService();
        assertEquals(expectedMenuMessage, Messages.menuInfoMessage(menuService.getMenuList()));
    }

    @Test
    public void whenUserSelectAInvalidMenuItem(){
        MenuService menuService = new MenuService();
        try {
            menuService.triggerActionItem(MenuTypes.MISSCLICK, null, null);
        } catch (MenuItemNotFoundException e) {
            assertNotNull(e);
        }
    }

}
