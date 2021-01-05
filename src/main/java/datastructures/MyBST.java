package datastructures;

import java.util.Map;

/*
Key is assumed to be an int
V is assumed to be a value
 */
public class MyBST<V> //implements Comparable<>
{
    /*@Override
    public int compareTo(K o)
    {
        return 0;
    }*/

    private class Node
    {
        public Node left;
        public Node right;
        public int key;
        public V value;

        public Node(int key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public MyBST(Node n)
    {
        root = n;
    }

    /*
    Use recursion when you can solve problems by breaking them down into smaller, repetitive problems
    Assumes we're adding distinct keys
     */
    public void addNode(Node n)
    {
        addNodeHelper(root, n);
    }

    public void addNodeHelper(Node curr, Node toAdd)
    {
        if (curr == null) curr = toAdd;
        else if (curr.key > toAdd.key) addNodeHelper(curr.left, toAdd);
        else addNodeHelper(curr.right, toAdd);
    }

    public V find(Integer key)
    {
        return findHelper(root, key);
    }

    public V findHelper(Node curr, Integer key)
    {
        if (curr == null) return null;
        else if (curr.key == (int) key) return curr.value;
        else if (curr.key > (int) key) return findHelper(curr.left, key);
        else return findHelper(curr.right, key);
    }

    public Node findMin()
    {
       Node curr = root;
       while (curr.left != null)
       {
           curr = curr.left;
       }
       return curr;
    }

    /*public void delete(Integer key)
    {
        deleteHelper(root, key);
    }*/

    /*public void deleteHelper(Node curr, Integer key)
    {
        if (curr == null)
            return;
        else if ((curr.key > key)
    }*/


}
