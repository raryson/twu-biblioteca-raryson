package com.twu.biblioteca;

public class EnumParser {
    public static MenuTypes intToEnum(int menuChoosed){
        switch(menuChoosed){
            case 1: {
                return MenuTypes.LISTOFBOOKS;
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
