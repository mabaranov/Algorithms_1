package com.company;

import java.util.BitSet;

public class BloomFilter
{
    public int filter_len;
    public BitSet bloomFilter;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bloomFilter = new BitSet(f_len);
    }

    // хэш-функции
    public int hash1(String str1)
    {
        int r = 17;
        int code = 0;

        // 17
        for(int i=0; i<str1.length(); i++)
        {
            code = (code * r + (int)str1.charAt(i)) % filter_len;
        }
        // реализация ...
        return code;
    }
    public int hash2(String str1)
    {
        int r = 223;
        int code = 0;

        // 17
        for(int i=0; i<str1.length(); i++)
        {
            code = (code * r + (int)str1.charAt(i)) % filter_len;
        }
        // реализация ...
        return code;
    }

    public void add(String str1)
    {
        // добавляем строку str1 в фильтр
        bloomFilter.set( hash1(str1) );
        bloomFilter.set( hash2(str1) );
    }

    public boolean isValue(String str1)
    {
        // проверка, имеется ли строка str1 в фильтре
        if (bloomFilter.get(hash1(str1))
        && bloomFilter.get(hash2(str1)))
            return true;
        return false;
    }
}