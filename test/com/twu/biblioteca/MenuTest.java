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


}
