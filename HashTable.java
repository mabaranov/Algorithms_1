package com.company;


public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        int hashIndex = 0;

        if (value == null)
            return hashIndex;

        for (int i = 0; i < value.length(); i++)
            hashIndex += value.charAt(i);

        hashIndex %= this.size;

        return hashIndex;
    }

    public int seekSlot(String value)
    {
        int hashIndex = hashFun(value);

        if (slots[hashIndex] == null)
            return hashIndex;


        int offset = hashIndex;
        boolean loopEnds = false;

        while (slots[offset] != null)
        {
            offset += this.step;
            if (offset >= slots.length)
            {
                loopEnds = true;
                offset -= slots.length;
            }
            if (loopEnds && offset >= hashIndex)
                break;
            if (slots[offset] == null)
                return offset;
        }

        return -1;
    }

    public int put(String value) {

        int index = seekSlot(value);

        if (index != -1)
            slots[index] = value;

        return index;
    }

    public int find(String value)
    {
        int hashIndex = hashFun(value);

        if ( slots[hashIndex] == value )
            return hashIndex;


        int offset = hashIndex;
        boolean loopEnds = false;

        while (slots[offset] != value)
        {
            offset += this.step;
            if (offset >= slots.length)
            {
                loopEnds = true;
                offset -= slots.length;
            }
            if (loopEnds && offset >= hashIndex)
                break;
            if (slots[offset] == value)
                return offset;
        }

        return -1;
    }
}