package com.twu.biblioteca.helpers;

import com.twu.biblioteca.helpers.MenuTypes;

public class EnumParser {
    public static MenuTypes intToEnum(int menuChoosed){
        switch(menuChoosed){
            case 1: {
                return MenuTypes.LISTOFBOOKS;
            }
            case 2: {
                return MenuTypes.CHECKOUTABOOK;
            }
            case 0: {
                return MenuTypes.EXIT;
            }
            default: {
                return MenuTypes.MISSCLICK;
            }
        }
    }
}
