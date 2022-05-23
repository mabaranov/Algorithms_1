package com.company;

import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if ( (v1 instanceof String) && (v2 instanceof String) )
        {
            String v1Trim = ((String) v1).trim();
            String v2Trim = ((String) v2).trim();

            int resCompare = v1Trim.compareTo(v2Trim);

            if (resCompare > 0) return 1;
            if (resCompare < 0) return -1;

            return 0;
        }

        if ( (v1 instanceof  Integer) && (v2 instanceof  Integer) )
        {
            int v1Int = (Integer) v1;
            int v2Int = (Integer) v2;

            if (v1Int > v2Int) return 1;
            if (v1Int < v2Int) return -1;

            return 0;
        }

        return 0;
    }

    public void add(T value)
    {
        Node<T> insNode = new Node<>(value);

        if (head == null)
        {
            head = insNode;
            tail = insNode;
            return;
        }

        // add to tail
        if ( ((compare(value, tail.value) == 1 || compare(value, tail.value) == 0) && _ascending)
                || ((compare(value, tail.value) == -1 || compare(value, tail.value) == 0) && !_ascending) )
        {
            tail.next = insNode;
            insNode.prev = tail;
            tail = insNode;
            return;
        }

        // add to head
        if ((compare(value, head.value) == -1 && _ascending)
                || (compare(value, head.value) == 1 && !_ascending))
        {
            insNode.next = head;
            head.prev = insNode;
            head = insNode;
            return;
        }

        Node<T> item = head;
        while(item != null)
        {
            int resCompare = compare(value, item.value);

            if ((resCompare == -1 && _ascending)
                    || ((resCompare == 1 || resCompare == 0) && !_ascending))
            {
                insNode.next = item;
                insNode.prev = item.prev;
                item.prev.next = insNode;
                item.prev = insNode;
                return;
            }

            item = item.next;
        }
    }

    public Node<T> find(T val)
    {
        Node<T> item = head;

        while( item != null )
        {
            int resCompare = compare(val, item.value);

            if (resCompare == 0) return item;
            if (resCompare == 1 && _ascending) break;
            if (resCompare == -1 && !_ascending) break;

            item = item.next;
        }
        return null;
    }

    public void delete(T val)
    {
        Node<T> item = head;
        while(item != null)
        {
            if (compare(val, item.value) == 0)
            {
                if (head == tail)
                {
                    clear(_ascending);
                }
                else if (item == head)
                {
                    head = item.next;
                    head.prev = null;
                }
                else if (item == tail)
                {
                    tail = item.prev;
                    tail.next = null;
                }
                else
                {
                    item.prev.next = item.next;
                    item.next.prev = item.prev;
                }

                return;
            }

            item = item.next;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
    }

    public int count()
    {
        int count = 0;
        Node<T> item = head;
        while(item != null)
        {
            count += 1;
            item = item.next;
        }
        return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}