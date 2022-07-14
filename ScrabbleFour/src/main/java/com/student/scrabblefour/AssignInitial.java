package com.student.scrabblefour;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class AssignInitial
{
    LinkedList<String> words;
    public AssignInitial(){};


    public boolean loadList() {
        File wordList = new File("C:\\Users\\BetaTester552\\IdeaProjects\\ScrabbleFour\\appdata\\wordlist.txt");
        BufferedReader br = null;
        String word = "";
        words= new LinkedList<>();
        try {
            br = new BufferedReader(new FileReader(wordList));
            char[] wordAsChar;
            while ((word = br.readLine()) != null) {

                System.out.println(word);
                words.add(word);
            }
            br.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public LinkedList<String> getWords() {
        return words;
    }
}
