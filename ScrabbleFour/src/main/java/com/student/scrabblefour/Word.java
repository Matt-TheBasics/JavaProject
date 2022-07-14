package com.student.scrabblefour;

public class Word
{
    private char letter1;
    private char letter2;
    private char letter3;
    private char letter4;
    private String complete;

    //getters
    public char getLetter1() {
        return letter1;
    }

    public char getLetter2() {
        return letter2;
    }

    public char getLetter3() {
        return letter3;
    }

    public char getLetter4() {
        return letter4;
    }

    public String getComplete(){
        return complete;
    }

    //setters

    public void setLetter1(char letter1) {
        this.letter1 = letter1;
    }

    public void setLetter2(char letter2) {
        this.letter2 = letter2;
    }

    public void setLetter3(char letter3) {
        this.letter3 = letter3;
    }

    public void setLetter4(char letter4) {
        this.letter4 = letter4;
    }

    public void setComplete(String complete)
    {

        this.complete = complete;
        setLetter1(complete.charAt(0));
        setLetter2(complete.charAt(1));
        setLetter3(complete.charAt(2));
        setLetter4(complete.charAt(3));
    }
}
