package com.ll.exam3;

import java.util.LinkedList;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private int size;
    private LinkedList<Entry<K, V>>[] table;

    public MyHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];

        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        bucket.add(newEntry);
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public int getIndex(K key) {
        return Math.abs(key.hashCode()) % INITIAL_CAPACITY;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println("Size: " + map.size());
    }
}
