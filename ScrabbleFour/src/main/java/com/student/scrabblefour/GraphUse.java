package com.student.scrabblefour;

import java.util.*;

public class GraphUse
{
    private  int  numVertex = 1200;
    private float[][] vertexStorage;
    private boolean[][] vertexSet;

    public GraphUse()
    {
        vertexStorage = new float[numVertex][numVertex];
        vertexSet = new boolean[numVertex][numVertex];
    };

    public void addNewEdge(char source, char destination, float weight)
    {
        float edgeValue = weight;
        vertexStorage[source][destination] = edgeValue;
        vertexSet[source][destination] = true;
    }

    public boolean hasEdge(char source, char destination)
    {
        return vertexSet[source][destination];
    }

    public float getEdgeValue(char source, char destination)
    {
        return vertexStorage[source][destination];
    }


}
