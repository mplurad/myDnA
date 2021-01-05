package datastructures;

import java.util.Iterator;

public class MyLinkedList<T>
{
    public class Node<T>
    {
        private T data;
        private Node next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }

        public void setData(T data)
        {
            this.data = data;
        }
    }

    private Node<T> root;
    private Node<T> tail;

    public MyLinkedList(T data)
    {
        this.root = new Node(data);
        tail = root;
    }

    public Node getFront()
    {
        return root;
    }

    public Node getBack()
    {
        return tail;
    }

    public void deleteFront()
    {
        root = root.next;
    }

    // This can be done in O(1) time with a double-linked list
    public void deleteBack()
    {
        if (root == tail)
            tail = null;
        else
        {
            Node currNode = root;
            while (currNode.next.next != null)
            {
                currNode = currNode.next;
            }
            tail = currNode;
            tail.next = null;
        }
    }

    public void addFront(Node n)
    {
        Node temp = root;
        root = n;
        root.next = temp;
    }

    public void addBack(Node n)
    {
        tail.next = n;
        tail = n;
    }

    /*public void printList()
    {
        Node currNode = root;
        while (currNode != tail)
        {
            System.out.printf((String) currNode.data);
            currNode = currNode.next;
        }
        printf()
    }*/
}
