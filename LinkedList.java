package com.company;

import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node item)
    {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
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
        Node prev = null;
        while (cur != null)
        {
            if (cur.value != _value)
            {
                prev = cur;
                cur = cur.next;
                continue;
            }

            if (prev == null)
                this.head = cur.next;
            else
                prev.next = cur.next;

            if (this.tail == cur)
                this.tail = prev;

            return true;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        if (this.head == null) return;

        Node cur = this.head;
        Node prev = null;
        while (cur != null)
        {
            if (cur.value != _value)
            {
                prev = cur;
                cur = cur.next;
                continue;
            }

            if (prev == null)
                this.head = cur.next;
            else
                prev.next = cur.next;

            if (this.tail == cur)
                this.tail = prev;

            cur = cur.next;
        }
    }

    public void clear()
    {
        head = null;
        tail = null;
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
        if (_nodeAfter == null)
        {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            return;
        }

        Node found = find(_nodeAfter.value);
        if (found == null) return;
        if (found == tail)
        {
            addInTail(_nodeToInsert);
            return;
        }

        Node next = found.next;
        found.next = _nodeToInsert;
        _nodeToInsert.next = next;
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}