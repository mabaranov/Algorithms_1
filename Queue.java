package com.company;

import java.util.*;

public class Queue<T>
{
    LinkedList<T> _items;

    public Queue()
    {
        _items = new LinkedList<>();
    }

    public void enqueue(T item)
    {
        _items.addLast( item );
    }

    public T dequeue()
    {
        if (_items.size() == 0)
            return null;

        return _items.pollFirst(); // null если очередь пустая
    }

    public int size()
    {
        return _items.size(); // размер очереди
    }

}