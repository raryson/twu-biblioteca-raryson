package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    public Menu() {
        MenuItem exitItem = new MenuItem("Exit", MenuTypes.EXIT, 0);
        MenuItem listOfBookItem = new MenuItem("List All Books", MenuTypes.LISTOFBOOKS, 1);
        menuList.add(exitItem);
        menuList.add(listOfBookItem);
    }

    private ArrayList<MenuItem> menuList = new ArrayList();

    public ArrayList<MenuItem> getMenuList() {
        return this.menuList;
    }

    public boolean triggerActionItem(MenuTypes triggeredOption) {
        for(MenuItem item : menuList) {
            if(item.getOption().equals(triggeredOption)) {
                return true;
            }
        }
        return false;
    }

}
