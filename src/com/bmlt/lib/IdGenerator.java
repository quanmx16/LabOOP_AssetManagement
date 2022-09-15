package com.bmlt.lib;

public class IdGenerator {

    public static String getBorrowId(int lastId) {
        String result = "";
        lastId++;
        if (lastId > 99) {
            result = "B" + lastId;
        } else if (lastId > 9) {
            result = "B0" + lastId;

        } else {
            result = "B00" + lastId;

        }
        return result;
    }
}
