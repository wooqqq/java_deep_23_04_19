package com.ll.exam1;

import java.util.stream.IntStream;

public class MyArrayList<T> {
    public boolean debug = false;
    private Object[] data;

    private int size = 0;

    public MyArrayList() {
        this(2);
    }

    public MyArrayList(int dataLength) {
        data = new Object[dataLength];
    }

    public int size() {
        return size;
    }

    public boolean add(T element) {
        // 만약에 공간이 부족하면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();
        data[size] = element;

        size++;

        return true;
    }

    public boolean add(int index, T element) {
        // 만약에 공간이 부족하면 새 data 객체를 만든다.
        makeNewDataIfNotEnough();

        // 해당 공간을 빈공간으로 만든다.
        makeEmptyIndex(index);

        data[index] = element;

        size++;

        return true;
    }

    public T set(int index, T element) {
        T old = (T) data[index];

        data[index] = element;

        return old;
    }

    public T remove(int index) {
        T old = (T) data[index];

        // 앞에서부터 자리 이동
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }

        data[size - 1] = null;

        size--;

        return old;
    }

    private void makeEmptyIndex(int index) {
        // 맨 뒤 승객부터 뒤로 1칸씩 이동

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
    }

    private void makeNewDataIfNotEnough() {
        // 먼저 공간이 부족한지 확인
        if (isNotEnough()) {
            makeNewData();
        }
    }

    private void makeNewData() {
        // 새 배열을 만든다. (새 업체를 만든다.)
        Object[] newData = new Object[data.length * 2];

        // 기존 창고에 있던 물품들을 전부 새 창고로 옮긴다.
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        if (debug) {
            System.out.printf("배열크기 증가 : %d => %d\n", data.length, newData.length);
        }

        // 기존 창고와 계약을 해지한다.
        // 더 이상 리스트가 기존 배열을 가리키지 않도록 하여, 자연스럽게 가비지컬렉팅이 되도록 한다.
        data = newData;
    }

    private boolean isNotEnough() {
        return size >= data.length;
    }

    public T get(int index) {
        return (T) data[index];
    }

    public int indexOf(T element) {
//        for (int i = 0; i < data.length; i++) {
//            if (element.equals(data[i])) return i;
//        }
//
//        return -1;

        // 더 깔끔한 버전
        return IntStream.range(0, size)
                .filter(index -> element.equals(data[index]))
                .findFirst()
                .orElse(-1);

        // 복잡한 연산까지 할 수 있는 버전
        // 예를들어서 index와 element 에 대한 복합조건을 filter에 사용가능
//                return IntStream.range(0, size)
//                .mapToObj(index -> new Object[]{index, data[index]})
//                .filter(arr -> element.equals(arr[1]))
//                .mapToInt(arr -> (int)arr[0])
//                .findFirst()
//                .orElse(-1);
    }

    public boolean contains(T element) {
        return indexOf(element) != -1;
    }
}
