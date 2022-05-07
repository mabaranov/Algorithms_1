package com.company;

import java.util.*;

public class LinkedList2v2
{
    public Node2 head;
    public Node2 tail;

    public LinkedList2v2()
    {
        this.head = new Node2();
        this.tail = new Node2();
        this.head.prev = null;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.tail.next = null;
    }

    public void addInTail(Node2 _item)
    {
        Node2 prevTail = this.tail.prev;

        prevTail.next = _item;
        _item.prev = prevTail;
        _item.next = this.tail;
        this.tail.prev = _item;
    }

    public Node2 find(int _value)
    {
        Node2 item = this.head.next;

        while( item != null )
        {
            if (item.value == _value && !item.dummy)
                return item;

            item = item.next;
        }

        return null;
    }

    public ArrayList<Node2> findAll(int _value)
    {
        ArrayList<Node2> node2s = new ArrayList<Node2>();

        Node2 item = this.head.next;
        while (item != this.tail) {
            if (item.value == _value)
                node2s.add(item);
            item = item.next;
        }

        return node2s;
    }

    public boolean remove(int _value)
    {
        Node2 item = this.head.next;
        while (item != this.tail)
        {
            if (item.value == _value)
            {
                item.prev.next = item.next;
                item.next.prev = item.prev;
                return true;
            }
            item = item.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node2 item = this.head.next;
        while (item != this.tail)
        {
            if (item.value == _value)
            {
                item.prev.next = item.next;
                item.next.prev = item.prev;
            }
            item = item.next;
        }
    }

    public void clear()
    {
        this.head.prev = null;
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.tail.next = null;
    }

    public int count()
    {
        int count = 0;
        Node2 item = this.head;
        while (item != this.tail) {
            count += 1;
            item = item.next;
        }
        return count-1;
    }

    public void insertAfter(Node2 _node2After, Node2 _node2ToInsert)
    {
        Node2 item = null;

        if (_node2After == null)
            item = this.head;
        else
            item = find(_node2After.value);

        if (item == null)
            return;

        item.next.prev = _node2ToInsert;
        _node2ToInsert.next = item.next;
        _node2ToInsert.prev = item;
        item.next = _node2ToInsert;
    }
}

class Node2
{
    public int value;
    public Node2 next;
    public Node2 prev;
    protected boolean dummy;

    public Node2(int _value)
    {
        value = _value;
        next = null;
        prev = null;
        dummy = false;
    }

    public Node2()
    {
        value = 0;
        next = null;
        prev = null;
        dummy = true;
    }
}