package com.company;

import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
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
        return slots[ hashFun( key ) ] == key;
    }

    public void put(String key, T value)
    {
        int index = hashFun( key );

        slots[index] = key;
        values[index] = value;
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