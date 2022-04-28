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
            {
                nodes.add(node);
            }
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        if (node.value == _value)
        {
            this.head = node.next;
            return true;
        }

        Node prev = node;
        node = node.next;
        while (node != null) {
            if (node.value == _value)
            {
                prev.next = node.next;
                if (this.tail == node ) this.tail = prev;
                return true;
            }
            prev = node;
            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        if (node.value == _value)
        {
            this.head = node.next;
        }

        Node prev = node;
        node = node.next;
        while (node != null) {
            if (node.value == _value)
            {
                prev.next = node.next;
                if (this.tail == node ) this.tail = prev;
            }
            prev = node;
            node = node.next;
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