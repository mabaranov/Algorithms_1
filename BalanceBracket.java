package com.company;

public class BalanceBracket {

    public static boolean CheckBalanceBracket(String _source)
    {
        Stack<Character> s1 = new Stack<>();

        int count = _source.length();
        for (int i=0; i<count; i++)
        {
            Character ch = _source.charAt(i);
            if (ch == '(')
            {
                s1.push(ch);
                continue;
            }

            if (ch == ')')
            {
                Character c = s1.pop();
                if (c == null)
                    return false;
            }
        }

        if (s1.size() == 0)
            return true;

        return false;
    }

}