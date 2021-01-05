package datastructures;

public class MyDynamicArray<E>
{
    private E[] data; // List of elements in the array of type E
    private int capacity; // The number of elements our array can hold
    private int size; // The number of elements currently in our array

    /* CONSTRUCTORS */
    public MyDynamicArray()
    {
        this.capacity = 10;
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    public MyDynamicArray(int initialCapacity)
    {
        this.data = (E[]) new Object[initialCapacity];
        this.capacity = initialCapacity;
        this.size = 0;
    }

    /* METHODS
    * i is the index
    * v is the value
    */

    public E get(int i)
    {
        return data[i];
    }

    public int getSize()
    {
        return size;
    }

    // Updates a value at index i
    public void set(E v, int i)
    {
        data[i] = v;
    }

    // Insert at the end of the list
    public void insert(E v)
    {
        if (this.size == this.capacity)
        {
            this.resize();
        }
        this.data[size] = v;
        this.size++;
    }

    // Insert at specified index
    public void insert(E v, int i)
    {
        if (this.size == this.capacity)
        {
            this.resize();
        }
        this.size++;
        for (int j = size; j >= i; j--)
        {
            this.data[j + 1] = this.data[j];
        }
        this.data[i] = v;
    }

    private void resize()
    {
        this.capacity = capacity * 2;
        E[] biggerArr = (E[]) new Object[this.capacity];
        for (int i = 0; i < size; i++)
        {
            biggerArr[i] = data[i];
        }
        this.data = biggerArr;
    }

    /**
     * delete value at index i
     * @param i is the index
     * @return true if there is a value at i
     */
    public boolean delete(int i)
    {
        if (i >= this.capacity || i < 0)
            return false;
        if (this.data[i] == null)
            return false;
        data[i] = null;
        for (int j = i; j < size - 1; j++)
        {
            data[j] = data[j + 1];
        }
        this.size--;
        return true;
    }

    public static void main(String[] args)
    {
        MyDynamicArray<Integer> a = new MyDynamicArray<Integer>();
        a.insert(7);
        a.insert(10);
        a.insert(12);
        a.insert(1, 0);
        a.insert(11, 3);

        for (int i = 0; i < a.getSize(); i++)
        {
            System.out.println(a.get(i));
        }
        System.out.println();

        a.delete(2);
        for (int i = 0; i < a.getSize(); i++)
        {
            System.out.println(a.get(i));
        }
        System.out.println();

        int b = 0;
        b *= 1;
        b *= 2;
        System.out.println(b);
    }
}