package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.MenuItemNotFoundException;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.infra.MenuData;
import com.twu.biblioteca.models.MenuItem;
import com.twu.biblioteca.services.MenuService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MenuServiceTest {

    @Test
    public void whenUserNeedToViewMenAssertToItensOnMenuIsNotNull() {
        MenuData.generateMenuList();
        MenuService menuService = new MenuService(MenuData.menuList);
        List<MenuItem> menuItens = menuService.getMenuList();

        MenuItem menuItemItered = menuItens.get(1);
        MenuTypes menuTypeItered = menuItemItered.getOption();
        assertNotNull(menuItemItered);
        assertNotNull(menuTypeItered);
    }

    @Test
    public void whenUserSelectAInvalidMenuItemAssertToThrowAException(){
        MenuData.generateMenuList();
        MenuService menuService = new MenuService(MenuData.menuList);
        try {
            menuService.triggerActionItem(MenuTypes.MISSCLICK, null, null);
        } catch (MenuItemNotFoundException e) {
            assertNotNull(e);
        }
    }

}
