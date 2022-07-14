package com.student.scrabblefour;

public class Alphabet
{
    private char[] alphabet = new char[26];
    public Alphabet()
    {
        char temp;
        int iCount = 0;
        for(temp = 'a'; temp <='z'; ++temp)
        {
            alphabet[iCount] = temp;
            iCount++;
        }
    };

    public char[] chars()
    {
        return alphabet;
    }
}
