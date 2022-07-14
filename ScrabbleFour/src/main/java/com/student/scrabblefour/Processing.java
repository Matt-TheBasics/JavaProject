package com.student.scrabblefour;

import java.util.ArrayList;
import java.util.LinkedList;

public class Processing implements WordProcessing
{

    @Override
    public boolean compare(String word1, String testWord)
    {
        if(word1.compareTo(testWord)==0)
        {
            return true;
        }

        return false;

    }

    @Override
    public int score(Word validWord, GraphUse g) {
        return 0;
    }



}
