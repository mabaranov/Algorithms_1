package com.company;

import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        Node item = this.head;

        while( item != null )
        {
            if (item.value == _value)
                return item;

            item = item.next;
        }

        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();

        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        if (this.head == null) return false;

        Node cur = this.head;
        while (cur != null)
        {
            if (cur.value != _value)
            {
                cur = cur.next;
                continue;
            }

            if (this.head == cur && this.tail == cur)
            {
                this.head = null;
                this.tail = null;
                return true;
            }

            if (this.head == cur) {
                this.head = cur.next;
                cur.next.prev = null;
                return true;
            }

            if (this.tail == cur) {
                this.tail = cur.prev;
                cur.prev.next = null;
                return true;
            }

            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
            return true;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        if (this.head == null) return;

        Node cur = this.head;
        while (cur != null)
        {
            if (cur.value != _value)
            {
                cur = cur.next;
                continue;
            }

            if (this.head == cur && this.tail == cur)
            {
                this.head = null;
                this.tail = null;
                return;
            }

            if (this.head == cur) {
                this.head = cur.next;
                cur.next.prev = null;
                continue;
            }

            if (this.tail == cur) {
                this.tail = cur.prev;
                cur.prev.next = null;
                continue;
            }

            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        int count = 0;
        Node node = this.head;
        while (node != null) {
            count += 1;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (this.head == null)
        {
            addInTail(_nodeToInsert);
            return;
        }

        if (_nodeAfter == null)
        {
            _nodeToInsert.next = this.head;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            return;
        }

        Node found = find(_nodeAfter.value);
        if (found == null) return;
        if (found == this.tail)
        {
            addInTail(_nodeToInsert);
            return;
        }

        found.next.prev = _nodeToInsert;
        _nodeToInsert.next = found.next;
        _nodeToInsert.prev = found;
        found.next = _nodeToInsert;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}