package com.student.scrabblefour;

import java.util.ArrayList;
import java.util.LinkedList;

public interface WordProcessing
{
    final int iWordLength = 4;
    boolean compare(String word1, String testWord);
    int score(Word validWord, GraphUse g);
}
