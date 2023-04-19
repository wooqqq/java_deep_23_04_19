package com.ll.exam1;

import java.sql.Struct;

public class MyArrayList<T> {
    private int size = 0;
    public int size() {
        return size;
    }

    public boolean add(String element) {
        size++;
        return true;
    }

    public String get(int index) {
        return "포도";
    }
}
