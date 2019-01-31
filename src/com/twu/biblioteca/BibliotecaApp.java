package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.ItemOnMenuNotFoundException;
import com.twu.biblioteca.helpers.EnumParser;
import com.twu.biblioteca.helpers.MenuTypes;
import com.twu.biblioteca.helpers.Messages;
import com.twu.biblioteca.services.MenuService;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.helloMessage());
        MenuService menuService = new MenuService();
        Scanner userInput = new Scanner(System.in);
        while(true){
            try {
                System.out.println(Messages.menuInfoMessage(menuService.getMenuList()));
                MenuTypes menuType = EnumParser.intToEnum(userInput.nextInt());
                menuService.triggerActionItem(menuType);
            } catch (ItemOnMenuNotFoundException e) {
                System.out.println(Messages.triggeredInvalidMenu());
            }
        }

    }
}
