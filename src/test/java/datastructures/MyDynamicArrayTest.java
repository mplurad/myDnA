package datastructures;

import static org.junit.jupiter.api.Assertions.*;

class MyDynamicArrayTest
{
    MyDynamicArray<Integer> a = new MyDynamicArray<Integer>();

    @org.junit.jupiter.api.Test
    void insert()
    {
        // [7]
        a.insert(7);
        assertEquals(7, a.get(0));

        // [7, 10]
        a.insert(10);
        assertEquals(10, a.get(1));

        // [1, 7, 10, 12]
        a.insert(12);
        a.insert(1, 0);
        assertEquals(1, a.get(0));
        assertEquals(7, a.get(1));

        // [1, 7, 11, 10, 12]
        a.insert(11, 2);
        assertEquals(11, a.get(2));
        assertEquals(10, a.get(3));
        assertEquals(12, a.get(4));
    }

    @org.junit.jupiter.api.Test
    void getSize()
    {
        assertEquals(0, a.getSize());
        a.insert(7);
        a.insert(8);
        assertEquals(2, a.getSize());
        a.delete(0);
        assertEquals(1, a.getSize());
    }

    @org.junit.jupiter.api.Test
    void set()
    {
        a.set(6, 7);
        assertEquals(6, a.get(7));
        a.set(7, 7);
        assertEquals(7, a.get(7));
    }

    // Consider a return type of void vs. boolean
    @org.junit.jupiter.api.Test
    void delete()
    {
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);

        // Size check
        assertFalse(a.delete(11));

        assertTrue(a.delete(2));

        // [1, 2, 4]
        assertEquals(1, a.get(0));
        assertEquals(2, a.get(1));
        assertEquals(4, a.get(2));
    }
}