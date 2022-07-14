package com.student.scrabblefour;

public class EdgeUse
{
    char source;
    char destination;
    int weight;

    public EdgeUse(char source, char destination, int weight)
    {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return source + "=>" +destination+" = "+weight;
    }
}
