package com.student.scrabblefour;

import java.util.LinkedList;

public class Player
{
    private String PlayerName;
    private int PlayerScore;
    LinkedList<String> instanceWords;
    private int gameLength;
    private int currentRound = 0;

    public void setGameLength(int gameLength) {
        this.gameLength = gameLength;
    }

    public int getGameLength() {
        return gameLength;
    }

    public int getCurrentRound() {
        return currentRound;
    }

    public void setCurrentRound(int currentRound) {
        this.currentRound += currentRound;
    }

    public void setInstanceWords(LinkedList<String> instanceWords) {
        this.instanceWords = instanceWords;
    }

    public void removeWord(String word)
    {
        instanceWords.removeFirstOccurrence(word);
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public int getPlayerScore() {
        return PlayerScore;
    }
    public void setPlayerName(String playerName) {
        PlayerName = playerName;
    }

    public void setPlayerScore(int playerScore) {
        PlayerScore += playerScore;
    }
}
