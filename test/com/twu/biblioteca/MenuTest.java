package com.twu.biblioteca;


import org.junit.Test;

import static org.junit.Assert.*;

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
        final String expectedMenuMessage = "Please, select one of this options:\n\t0 - Exit\t1 - List All Books";
        Menu menu = new Menu();
        assertEquals(expectedMenuMessage, Messages.menuInfoMessage(menu.getMenuList()));
    }


    @Test
    public void whenUserSelectAValidMenuItem(){
        Menu menu = new Menu();
        assertTrue(menu.triggerActionItem(menu.getMenuList().get(0).getOption()));
    }

    @Test
    public void whenUserSelectAInvalidMenuItem(){
        Menu menu = new Menu();
        assertFalse(menu.triggerActionItem(null));
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

}
