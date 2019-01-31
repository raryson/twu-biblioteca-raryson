package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println(Messages.helloMessage());
        Menu menu = new Menu();
        Scanner userInput = new Scanner(System.in);
        System.out.println(Messages.menuInfoMessage(menu.getMenuList()));
        try {
            MenuTypes menuType = EnumParser.intToEnum(userInput.nextInt());
            menu.triggerActionItem(menuType);
        } catch (ItemOnMenuNotFoundException e) {
            System.out.println(Messages.triggeredInvalidMenu());
        }
    }
}
