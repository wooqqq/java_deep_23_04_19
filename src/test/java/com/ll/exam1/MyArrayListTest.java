package com.ll.exam1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyArrayListTest {
    @Test
    void testSize() {
        MyArrayList<String> list = new MyArrayList<>();
        assertEquals(0, list.size());
    }
}
