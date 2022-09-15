package com.bmlt.menu;

import com.bmlt.lib.Utils;
import java.util.ArrayList;

public class Menu extends ArrayList<String> implements I_Menu {

    @Override
    public void addItem(String s) {
        this.add(s);
    }

    @Override
    public int getChoice() {
        int choice;
        choice = Utils.getInt("Select your choice: ", 1, this.size());
        return choice;
    }

    @Override
    public void showMenu() {
        for (int i = 0; i < this.size(); i++) {
            System.out.println((i + 1) + "." + this.get(i));
        }

    }

    @Override
    public boolean confirmYesNo(String welcome) {
        boolean choice;
        choice = Utils.confirmYesNo(welcome);
        return choice;
    }

}
