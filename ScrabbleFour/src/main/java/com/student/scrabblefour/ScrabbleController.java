package com.student.scrabblefour;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import org.controlsfx.control.spreadsheet.Grid;

import java.net.URL;
import java.util.*;

public class ScrabbleController implements Initializable {
    @FXML
    public MenuItem mbNewgame, mbClose;

    @FXML
    private Circle p1L1;
    @FXML
    private Circle p1L2;
    @FXML
    private Circle p1L3;
    @FXML
    private Circle p1L4;

    @FXML
    private TilePane Player1Pane;
    @FXML
    private TilePane Player2Pane;
    @FXML
    private Pane GridParent;
    @FXML
    private GridPane outputGrid;
    @FXML
    private Button btnTest;
    @FXML
    private TextArea taTest;
    @FXML
    private MenuItem btnClose;
    @FXML
    private TextField p1input, p2input;
    @FXML
    private Button btnP1, btnP2;
    @FXML
    private Label lblScore1, lblScore2;
    @FXML
    private ListView chosenWords;
    @FXML
    private ProgressBar progressBar;


    private double startX;
    private double startY;

    private Graph graph;

    private Player player1, player2;


    LinkedList<String> wordList;

    private GraphUse gu;
    private int round;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        methods();
    }

    public void exit() {
        System.exit(0);
    }


    @FXML
    private void moveCircle(Node node) {
        double X = node.getTranslateX();
        double Y = node.getTranslateY();
        node.setOnMousePressed(e ->
        {
            startX = e.getSceneX() - node.getTranslateX();
            startY = e.getSceneY() - node.getTranslateY();

        });
        node.setOnMouseDragged(e ->
        {
            node.setTranslateX(e.getSceneX() - startX);
            node.setTranslateY(e.getSceneY() - startY);
        });

        node.setOnMouseReleased(e ->
        {
            double nodePosX = node.getTranslateX();
            double nodePosY = node.getTranslateY();

            node.setManaged(false);


        });

    }


    public void methods() {
        player1 = new Player();
        player2 = new Player();

        AssignInitial ai = new AssignInitial();
        boolean b = ai.loadList();
        Alphabet alphabet = new Alphabet();
        char[] letters = alphabet.chars();
        Random r = new Random();
        int iCount = 0;
        List<Graph.Edge> edges = new ArrayList<Graph.Edge>();
        Graph.Edge temp;
        LinkedList<Graph.Vertex> vertiList = new LinkedList<>();
        LinkedList<VertexUse> vertexUses = new LinkedList<>();
        ArrayList<EdgeUse> edgeUseList = new ArrayList<EdgeUse>();
        char n = 'a';
        for (int i = 0; i < 26; i++) {

            Graph.Vertex characterVertex = new Graph.Vertex<>(letters[i], i);
            vertiList.add(i, characterVertex);
            VertexUse tempVert = new VertexUse(n, i);
            vertexUses.add(tempVert);
            ++n;
        }
        System.out.println(vertiList);
        while (iCount <= letters.length - 1) {
            EdgeUse[] tempArr = new EdgeUse[25];

            for (char a = 'a'; a <= 'z'; ++a) {
                Graph.Vertex vertex = new Graph.Vertex<>(a, 1);
                temp = new Graph.Edge(r.nextInt(3) + 1, vertiList.get(iCount), vertex);
                edges.add(iCount, temp);
                EdgeUse tempEdge = new EdgeUse(vertexUses.get(iCount).getValue(), a, r.nextInt(3) + 1);
                edgeUseList.add(iCount, tempEdge);
            }
            iCount++;
        }

        graph = new Graph(Graph.TYPE.UNDIRECTED, vertiList, edges);

        gu = new GraphUse();

        for (EdgeUse e : edgeUseList) {
            gu.addNewEdge(e.source, e.destination, e.weight);
        }

        wordList = ai.getWords();
        btnP1.setDisable(true);
        btnP2.setDisable(true);

    }

    public void ButtonClick() {
        String test = taTest.getText();
        Word word = new Word();
        word.setComplete(test);
        Processing p = new Processing();
        int score = 0;
        for (String s : wordList) {
            if (p.compare(s, word.getComplete())) {
                System.out.println("Word was found!");
                if (gu.hasEdge(word.getLetter1(), word.getLetter2())) {
                    if (gu.hasEdge(word.getLetter2(), word.getLetter3())) {
                        if (gu.hasEdge(word.getLetter3(), word.getLetter4())) {
                            score += gu.getEdgeValue(word.getLetter1(), word.getLetter2()) + gu.getEdgeValue(word.getLetter2(), word.getLetter3()) + gu.getEdgeValue(word.getLetter3(), word.getLetter4());
                        }
                    }

                }
            }
        }

        System.out.println(score);

    }

    public void CheckP1Click() {
        if (50>player1.getPlayerScore()) {

            String toCheck = p1input.getText();
            if (toCheck.length() == 4) {
                p1input.clear();

                Word word = new Word();
                word.setComplete(toCheck);
                Processing p = new Processing();
                int score = 0;
                for (String s : wordList) {
                    if (p.compare(s, word.getComplete())) {
                        System.out.println("Word was found!");
                        if (gu.hasEdge(word.getLetter1(), word.getLetter2())) {
                            if (gu.hasEdge(word.getLetter2(), word.getLetter3())) {
                                if (gu.hasEdge(word.getLetter3(), word.getLetter4())) {
                                    score += gu.getEdgeValue(word.getLetter1(), word.getLetter2()) + gu.getEdgeValue(word.getLetter2(), word.getLetter3()) + gu.getEdgeValue(word.getLetter3(), word.getLetter4());
                                    player1.setPlayerScore(score);


                                }
                            }

                        }
                        chosenWords.getItems().add(toCheck);

                    }
                }
                player1.removeWord(toCheck);
                player2.removeWord(toCheck);
                btnP1.setDisable(true);
                btnP2.setDisable(false);
            } else {
                p1input.clear();
                Alert newAlert = new Alert(Alert.AlertType.ERROR, "Please enter a four letter word!");
                newAlert.show();
            }


            lblScore1.setText("Score: " + player1.getPlayerScore());
        }
        else
        {

            chosenWords.getItems().add("GAME OVER");
            if (player1.getPlayerScore() > player2.getPlayerScore()) {
                chosenWords.getItems().add("PLAYER 1 WINS!");
            } else {
                chosenWords.getItems().add("PLAYER 2 WINS!");
            }
        }

    }



    public void CheckP2Click() {
        if(50>player2.getPlayerScore()) {

            String checkWord = p2input.getText();
            if (checkWord.length() == 4) {
                p2input.clear();
                Word word = new Word();
                word.setComplete(checkWord);
                Processing p = new Processing();
                int score = 0;
                for (String s : wordList) {
                    if (p.compare(s, word.getComplete())) {
                        System.out.println("Word was found!");
                        if (gu.hasEdge(word.getLetter1(), word.getLetter2())) {
                            if (gu.hasEdge(word.getLetter2(), word.getLetter3())) {
                                if (gu.hasEdge(word.getLetter3(), word.getLetter4())) {
                                    score += gu.getEdgeValue(word.getLetter1(), word.getLetter2()) + gu.getEdgeValue(word.getLetter2(), word.getLetter3()) + gu.getEdgeValue(word.getLetter3(), word.getLetter4());
                                    player2.setPlayerScore(score);


                                }
                            }

                        }
                        chosenWords.getItems().add(checkWord);
                        if (player2.getCurrentRound() == player2.getGameLength()) {
                            chosenWords.getItems().add("GAME OVER");
                            if (player1.getPlayerScore() > player2.getPlayerScore()) {
                                chosenWords.getItems().add("PLAYER 1 WINS!");
                            } else {
                                chosenWords.getItems().add("PLAYER 2 WINS!");
                            }
                        }
                    }
                }
                player2.removeWord(checkWord);
                player1.removeWord(checkWord);
                btnP1.setDisable(false);
                btnP2.setDisable(true);
            } else {
                p1input.clear();
                Alert newAlert = new Alert(Alert.AlertType.ERROR, "Please enter a four letter word!");
                newAlert.show();
            }

            lblScore2.setText("Score: " + player2.getPlayerScore());
        }
        else
            {
                chosenWords.getItems().add("GAME OVER");
                if (player1.getPlayerScore() > player2.getPlayerScore()) {
                    chosenWords.getItems().add("PLAYER 1 WINS!");
                } else {
                    chosenWords.getItems().add("PLAYER 2 WINS!");
                }
            }


    }


    public void ClickNewGameTwenty()
    {
        player1 = new Player();
        player1.setPlayerName("Player 1");
        player2 = new Player();
        player2.setPlayerName("Player 2");
        player1.setInstanceWords(wordList);
        player2.setInstanceWords(wordList);
        player1.setGameLength(10);
        player2.setGameLength(10);
        round=10;
        btnP1.setDisable(false);
    }
    public void ClickNewGameThirty()
    {
        player1 = new Player();
        player1.setPlayerName("Player 1");
        player2 = new Player();
        player2.setPlayerName("Player 2");
        player1.setInstanceWords(wordList);
        player2.setInstanceWords(wordList);
        player1.setGameLength(15);
        player2.setGameLength(15);

        btnP1.setDisable(false);
    }
    public void ClickNewGameFifty()
    {
        player1 = new Player();
        player1.setPlayerName("Player 1");
        player2 = new Player();
        player2.setPlayerName("Player 2");
        player1.setInstanceWords(wordList);
        player2.setInstanceWords(wordList);
        player1.setGameLength(25);
        player2.setGameLength(25);

        btnP1.setDisable(false);
    }


}