package com.ll.exam1;

import java.sql.Struct;

public class MyArrayList<T> {
    private String[] data = new String[100];

    private int size = 0;

    public int size() {
        return size;
    }

    public boolean add(String element) {
        // 만약에 공간이 부족하면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();
        data[size] = element;

        size++;

        return true;
    }

    private void makeNewDataIfNotEnough() {
        // 먼저 공간이 부족한지 확인
        if (ifNotEnough()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        // 새 배열을 만든다. (새 업체를 만든다.)
        String[] newData = new String[data.length * 2];

        // 기존 창고에 있던 물품들을 전부 새 창고로 옮긴다.
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        // 기존 창고와 계약을 해지한다.
        // 더 이상 리스트가 기존 배열을 가리키지 않도록 하여, 자연스럽게 가비지컬렉팅이 되도록 한다.
        data = newData;
    }

    private boolean ifNotEnough() {
        return size >= data.length;
    }

    public String get(int index) {
        return data[index];
    }
}
