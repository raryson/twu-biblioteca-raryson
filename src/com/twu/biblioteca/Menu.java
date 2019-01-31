package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {

    public Menu() {
        MenuItem listOfBookItem = new MenuItem("List All Books", "1");
        menuList.add(listOfBookItem);
    }

    private ArrayList<MenuItem> menuList = new ArrayList();

    public ArrayList<MenuItem> getMenuList() {
        return this.menuList;
    }

    public boolean triggerActionItem(String triggeredOption) {
        for(MenuItem item : menuList) {
            if(item.getOption().equals(triggeredOption)) {
                return true;
            }
        }
        return false;
    }

}
