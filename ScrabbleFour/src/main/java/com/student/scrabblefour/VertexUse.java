package com.student.scrabblefour;

public class VertexUse
{
    private char value;
    private int key;
    private EdgeUse[] edges;

    public char getValue() {
        return value;
    }

    public EdgeUse[] getEdges() {
        return edges;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setEdges(EdgeUse[] edges) {
        this.edges = edges;
    }

    public int getKey() {
        return key;
    }

    public VertexUse(char value, int key)
    {
        this.value = value;
        this.key = key;
    }

    @Override
    public String toString()
    {
        return value + " => "+ edges.length;
    }

}
