package com.twu.biblioteca;


import com.twu.biblioteca.exceptions.ItemOnMenuNotFoundException;
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
            assertNotNull(menuItem.getName());
            assertNotNull(menuItem.getOption());
        }
    }

    @Test
    public void whenMenuAreShowedOnScreen() {
        final String expectedMenuMessage = "Please, select one of this options:\n\t0 - Exit\t1 - List All Books" +
                "\t2 - Checkout a Book";
        MenuService menuService = new MenuService();
        assertEquals(expectedMenuMessage, Messages.menuInfoMessage(menuService.getMenuList()));
    }

    @Test
    public void whenUserSelectAInvalidMenuItem(){
        MenuService menuService = new MenuService();
        try {
            menuService.triggerActionItem(MenuTypes.MISSCLICK, null, null);
        } catch (ItemOnMenuNotFoundException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void whenUserTriggerAInvalidMenuItem(){
        final String expectedMessage = "Sorry, invalid menu input, try again please!";
        assertEquals(expectedMessage, Messages.triggeredInvalidMenu());
    }

    @Test
    public void whenUserTriggerExitEvent() {
        final String expectedMessage = "Bye bye";
        assertEquals(expectedMessage, Messages.triggeredExit());
    }

    @Test
    public void whenUserSelectCheckoutABook() {
        final String expectedMessage = "Enter with a book name to checkout";
        assertEquals(expectedMessage, Messages.enterYourBookToCheckout());
    }

}
