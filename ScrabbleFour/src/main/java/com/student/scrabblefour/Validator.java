package com.student.scrabblefour;



import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


//validator class to validate all graph items
public class Validator
{
    public Validator(){};

    public LinkedList<EdgeUse> validList(List<EdgeUse> tobeTested, LinkedList<String> wordList)
    {
        LinkedList<EdgeUse> temp = new LinkedList<EdgeUse>(tobeTested);
        LinkedList<EdgeUse> tobeRemoved = new LinkedList<EdgeUse>();

        Iterator<String> words = wordList.iterator();
        int counter = 0;

        while(words.hasNext())
        {
            String tempWord = String.valueOf(words.next());
            //two letter existence
            String part1 = tempWord.substring(0,2);
            String part2 = tempWord.substring(1,3);
            String part3 = tempWord.substring(2);

            //three letter existence
            String part4 = tempWord.substring(0,2);
            String part5 = tempWord.substring(1,3);

            for(EdgeUse test:temp)
            {

                if(!(twoLetter(part1,test) || twoLetter(part2,test) || twoLetter(part3,test)))
                {

                    tobeRemoved.add(test);
                    counter++;
                }

                if(!(threeLetter(part4, test) || threeLetter(part5, test)))
                {
                    tobeRemoved.add(test);
                    counter++;
                }
            }

        }

        temp.removeAll(tobeRemoved);
        System.out.println(counter);



        return temp;

    }

    public boolean twoLetter(String test, EdgeUse temp)
    {
       // if((test.charAt(0)==temp.source) && (test.charAt(1) == temp.destination))
        {
       //     return true;
        }
        return false;
    }
    public boolean threeLetter(String test, EdgeUse temp)
    {
        if((twoLetter(test.substring(0,2),temp)) && (twoLetter(test.substring(1),temp)))
        {
            return true;
        }
        return false;
    }


}
