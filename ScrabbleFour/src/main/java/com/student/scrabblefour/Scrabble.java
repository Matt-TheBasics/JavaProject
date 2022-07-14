package com.student.scrabblefour;

import java.util.Arrays;

public class Scrabble
{
    private char[][] letterGrid;

    public Scrabble()
    {
        letterGrid= new char[15][15];
        for(char[] row: letterGrid)
        {
            Arrays.fill(row, '-');
        }
    };

    public char[][] getLetterGrid() {
        return letterGrid;
    }


}
