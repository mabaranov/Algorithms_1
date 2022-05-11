package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        if (new_capacity < 16)
            new_capacity = 16;

        T[] new_array = (T[]) Array.newInstance(this.clazz, new_capacity);

        for (int i=0; i<count; i++)
        {
            new_array[i] = array[i];
        }

        array = new_array;
        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (index < 0 || index > count-1)
            throw new ArrayIndexOutOfBoundsException();

        return array[index];
    }

    public void append(T itm)
    {
        if (count+1 > capacity)
            makeArray(capacity*2);

        array[count] = itm;
        count += 1;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > count)
            throw new ArrayIndexOutOfBoundsException();

        if (index == count)
        {
            append(itm);
            return;
        }

        if (count+1 > capacity)
            makeArray(capacity*2);

        T[] new_array = (T[]) Array.newInstance(this.clazz, capacity*2);

        for (int i=0; i<index; i++)
            new_array[i] = array[i];

        new_array[index] = itm;

        for (int i=index; i<count; i++)
            new_array[i+1] = array[i];

        array = new_array;
        count += 1;
    }

    public void remove(int index)
    {
        if (index < 0 || index > count-1)
            throw new ArrayIndexOutOfBoundsException();



        for (int i=index+1; i<count; i++)
        {
            array[i - 1] = array[i];

            if (i == count-1)
                array[i] = null;
        }

        if (index == count-1)
            array[index] = null;

        count -= 1;
        float percent = (float)capacity/count;
        if (percent > 2.0)
            makeArray( (int)(capacity/1.5) );
    }

}