package com.company;

import java.util.*;

public class Deque<T>
{
    LinkedList<T> _items;

    public Deque()
    {
        _items = new LinkedList<T>();
    }

    public void addFront(T item)
    {
        _items.addFirst( item );
    }

    public void addTail(T item)
    {
        _items.addLast( item );
    }

    public T removeFront()
    {
        if (_items.size() == 0)
            return null;

        return _items.removeFirst();
    }

    public T removeTail()
    {
        if (_items.size() == 0)
            return null;

        return _items.removeLast();
    }

    public int size()
    {
        return _items.size();
    }
}