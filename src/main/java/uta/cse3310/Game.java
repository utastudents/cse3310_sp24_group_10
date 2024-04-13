package uta.cse3310;

import java.util.ArrayList;

public class Game {

    private char[][] grid = new char[50][50];
    private ArrayList<String> words = new ArrayList<String>();
    private ArrayList<Integer> wordsFound = new ArrayList<Integer>();
    private ArrayList<Player> Players = new ArrayList<Player>();
    private GameTimer timer = new GameTimer();

    public void startGame(){

        timer.start();
    }

    public void initializeGrid(){

    }

    public void fillRandom(){

    }

    public void placeWords(){

    }

    public Boolean isWordFound(String word){
        boolean wordFound = false;
        return wordFound;
    }

    public void highlightWord(){


    }


    public void timer(){



    }

    public void update(){

    }

    public void surrender(){

    }

    public void backToLobby(){

    }

    
    public void checkWin(){

        int winner = -1;
        int winnerIdx = 0;

        //determine winner
        for(int i = 0; i < Players.size(); i++)
        {
            if(Players.get(i).getScore() > winner)
            {
                winner = Players.get(i).getScore(); 
                winnerIdx = i;
            }
        }

        //reset all players scores
        for(int i = 0; i < Players.size(); i++)
        {
            Players.get(i).setScore(0); 
        }

        System.out.println("The Winner is: " + Players.get(winnerIdx).name + System.lineSeparator());

        Players.get(winnerIdx).setWins(++Players.get(winnerIdx).wins);

    }
    
}


