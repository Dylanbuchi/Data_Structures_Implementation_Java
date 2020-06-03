package ds.hashes;

import jdk.jfr.DataAmount;
import ds.linkedlist.MyLinkedList;

@SuppressWarnings("unchecked")

public class MyHashTable<K, V> implements IHashTable<K, V> {

    private static class Hash<K, V> implements Comparable<Hash<K, V>> {
        private K key;
        private V value;

        private Hash(K key, V value) {
            super();
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Hash<K, V> other) {

            return ((Comparable<K>) this.key).compareTo(other.key);
        }

        @Override
        public String toString() {

            return "[key: " + key + "]," + "[value: " + value + "]";
        }
    }

    private int count;
    private int tableSize;
    private double maxLoadFactor;
    private MyLinkedList<Hash<K, V>>[] table;

    public MyHashTable() {
        this(16);
    }

    public MyHashTable(int tableSize) {
        super();
        this.count = 0;
        this.tableSize = tableSize;
        this.maxLoadFactor = 0.75;
        this.table = (MyLinkedList<Hash<K, V>>[]) new MyLinkedList[tableSize];

        initializeTable();

    }

    private void initializeTable() {
        for (int i = 0; i < tableSize; i++) {
            table[i] = new MyLinkedList<Hash<K, V>>();
        }

    }

    @Override
    public boolean add(K key, V value) {

        Hash<K, V> data = new Hash<>(key, value);

        int hashValue = getHashValue(key);

        table[hashValue].append(data);
        count++;

        return true;
    }

    @Override
    public boolean remove(K key, V value) {
        if (table == null) {
            return false;
        }

        int hashValue = getHashValue(key);

        table[hashValue].popLast();
        count--;

        return true;
    }

    private int getHashValue(K key) {
        int hashValue = key.hashCode();

        hashValue = Math.abs(hashValue) % tableSize;
        return hashValue;
    }

    public static void main(String[] args) {
        var ht = new MyHashTable<String, Integer>();
        System.out.println(ht.add("dylan", 200));
    }

}