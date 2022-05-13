package com.company;

import java.util.*;

public class Stack<T>
{
    LinkedList<T> items;

    public Stack()
    {
        items = new LinkedList<T>();
    }

    public int size()
    {
        return items.size();
    }

    public T pop()
    {
        if (items.size() == 0)
            return null;

        T val = items.getLast();
        items.removeLast();
        return val;
    }

    public void push(T val)
    {
        items.addLast(val);
    }

    public T peek()
    {
        if (items.size() == 0)
            return null;

        T val = items.getLast();

        return val;
    }
}