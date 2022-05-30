package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PowerSet
{
    public ArrayList<String> items;

    public PowerSet()
    {
        items = new ArrayList<>();
    }

    public int size()
    {
        return items.size();
    }

    public void put(String value)
    {
        if ( !get( value ) ) items.add(value);
    }

    public boolean get(String value)
    {
        return items.contains( value );
    }

    public boolean remove(String value)
    {
        return items.remove(value);
    }

    public PowerSet intersection(PowerSet set2)
    {
        // пересечение текущего множества и set2
        PowerSet newSet = new PowerSet();

        for (String element: items)
        {
            if (set2.get(element))
                newSet.put(element);
        }

        return newSet;
    }

    public PowerSet union(PowerSet set2)
    {
        // объединение текущего множества и set2
        PowerSet newSet = new PowerSet();

        for (String element: items)
            newSet.put(element);

        for (String element: set2.items)
            if (!newSet.get(element))
                newSet.put(element);

        return newSet;
    }

    public PowerSet difference(PowerSet set2)
    {
        // разница текущего множества и set2
        PowerSet newSet = new PowerSet();

        for (String element: items)
            newSet.put(element);

        for (String element: set2.items)
            newSet.remove(element);

        return newSet;
    }

    public boolean isSubset(PowerSet set2)
    {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false

        for (String element: set2.items)
            if (!get(element))
                return false;

        return true;
    }
}