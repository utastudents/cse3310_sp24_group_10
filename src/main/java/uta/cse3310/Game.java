package uta.cse3310;

import java.util.ArrayList;

public class Game {

    private char[][] grid;
    private ArrayList<String> words;
    private ArrayList<Player> players;
    private GameTimer timer;
    private int numWordsFound;

    public Game(ArrayList<Player> players) {
        
        this.grid = new char[50][50];
        this.words = new ArrayList<String>();
        this.players = new ArrayList<Player>(players);
        this.timer = new GameTimer();
        this.numWordsFound = 0;
    }

    public void startGame(){

        timer.start();
        
        //testing timer
        while(timer.getSeconds() <= 30)
        {

        }

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

        //check to end game
        for(int i = 0; i < words.size(); i++)
        {
            if(words.get(i).equals(""))
            {
                numWordsFound++;
            }
        }

        if(numWordsFound == words.size())
        {
            this.checkWin();
        }

    }

    public void surrender(){

    }

    public void backToLobby(){

    }

    
    public void checkWin(){

        int winner = -1;
        int winnerIdx = 0;

        //determine winner
        for(int i = 0; i < players.size(); i++)
        {
            if(players.get(i).getScore() > winner)
            {
                winner = players.get(i).getScore(); 
                winnerIdx = i;
            }
        }

        //reset all players scores
        for(int i = 0; i < players.size(); i++)
        {
            players.get(i).setScore(0); 
        }

        Player pWinner = players.get(winnerIdx);

        System.out.println("The Winner is: " + pWinner.getName() + System.lineSeparator());

        pWinner.addWin();

    }
    
}


