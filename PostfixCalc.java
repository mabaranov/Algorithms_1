package com.company;

public class PostfixCalc {

    public static int Calc( String _source )
    {
        Stack<Character> s1 = new Stack<>();
        for (int i=_source.length()-1; i>=0; i--)
        {
            if(_source.charAt(i) != ' ')
                s1.push(_source.charAt(i));
        }

        Stack<Integer> s2 = new Stack<>();
        int count = s1.size();
        for (int i=0; i<count; i++)
        {
            Character op = s1.pop();
            int val = Character.getNumericValue(op);
            if (val >= 0)
            {
                s2.push(val);
            }
            else
            {
                if ( op == '=' )
                    return s2.pop();

                int right = s2.pop();
                int left = s2.pop();

                switch (op)
                {
                    case '+': s2.push(left + right ); break;
                    case '-': s2.push(left - right ); break;
                    case '*': s2.push(left * right ); break;
                    case '/': s2.push(left / right ); break;
                }
            }
        }

        if (s2.size() == 1)
            return s2.pop();

        return 0;
    }

}