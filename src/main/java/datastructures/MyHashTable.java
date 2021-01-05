package datastructures;

import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/*
Java: HashTable, HashMap, ConcurrentHashMap, LinkedHashMap
The above are structures based upon hashing and the implementation of Map interface
If threaded application use HashTable or ConcurrentHashMap since HashMap is unsynchronized
Hashtable does not allow null keys or values. HashMap allows one null key and any number of null values.
In the event that you want predictable iteration order use LinkedHashMap.
 */

public class MyHashTable<K, V>
{
    private int capacity;
    private int size;
    private LinkedList<Map.Entry<K, V>>[] data;

    public MyHashTable()
    {
        capacity = 10;
        data = new LinkedList[10];
        size = 0;
    }

    public MyHashTable(int capacity)
    {
        this.capacity = capacity;
        data = new LinkedList[capacity];
        size = 0;
    }

    // TODO: Consider the case with duplicate keys
    public void put(Map.Entry<K, V> pair)
    {
        if (size == capacity) this.resize();
        data[getIndex(pair.getKey())].add(pair);
        size++;
    }

    private void resize()
    {
        LinkedList<Map.Entry<K, V>>[] biggerArr = new LinkedList[capacity * 2];
        for (int i = 0; i < data.length; i++)
            biggerArr[i] = data[i];
        data = biggerArr;
    }

    public V getValue(K key)
    {
        int index = getIndex(key);
        ListIterator<Map.Entry<K, V>> listIterator = data[index].listIterator();
        while (listIterator.hasNext())
            if (listIterator.next().getKey().equals(key)) return listIterator.next().getValue();
        return null;
    }

    // Gets an index from a key
    public int getIndex(K key)
    {
        return Math.abs(key.hashCode()) % capacity;
    }

    public void delete(K key, V value)
    {
        Map.Entry<K, V> pair = new AbstractMap.SimpleEntry<K, V>(key, value);
        data[getIndex(key)].removeFirstOccurrence(pair);
    }

}