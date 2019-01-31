package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MenuTest {

    @Test
    public void whenUserNeedToViewMenu() {
        Menu menuService = new Menu();
        for(MenuItem menuItem : menuService.getMenuList()){
            assertNotNull(menuItem.getName());
            assertNotNull(menuItem.getOption());
        }
    }

    @Test
    public void whenMenuAreShowedOnScreen() {
        final String expectedMenuMessage = "\t1 - List All Books";
        Menu menu = new Menu();
        assertEquals(Messages.menuInfoMessage(menu.getMenuList()), expectedMenuMessage);
    }


}
