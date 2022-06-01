package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.OptionalInt;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    // ...

    public NativeCache(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
    }

    public int hashFun(String key)
    {
        int hashIndex = 0;

        if (key == null)
            return hashIndex;

        for (int i = 0; i < key.length(); i++)
            hashIndex += key.charAt(i);

        hashIndex %= this.size;

        return hashIndex;
    }

    public boolean isKey(String key)
    {
        int hash = hashFun( key );
        if (slots[hash] == key)
        {
            hits[hash] += 1;
            return true;
        }
        return false;
    }

    public void put(String key, T value)
    {
        int index = hashFun( key );

        if (slots[index] == null)
        {
            slots[index] = key;
            values[index] = value;
        }
        else {
            int indx = 0;
            int min = hits[indx];
            for (int i = 1; i < hits.length; i++) {
                if (hits[i] < min) {
                    min = hits[i];
                    indx = i;
                }
            }

            slots[indx] = key;
            values[indx] = value;
        }
    }

    public T get(String key)
    {
        // возвращает value для key,
        // или null если ключ не найден
        if ( isKey( key ) )
        {
            int index = hashFun( key );
            return values[index];
        }
        return null;
    }
}