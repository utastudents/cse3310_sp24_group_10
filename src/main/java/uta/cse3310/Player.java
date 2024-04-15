package uta.cse3310;

public class Player {
<<<<<<< HEAD

    private int score;
    private int wins;
    private String name;
    private String color;
    private boolean readyStatus;

    public Player(String name, String color) {
      
      this.score = 0;
      this.wins = 0;
      this.name = name;
      this.color = color;
      this.readyStatus = false;
    
    }
=======
    String name;
    int score;
    int wins;
    String color;
    boolean readyStatus;
>>>>>>> origin/main

    Player(String name, int score, int wins, String color, boolean readyStatus){
      this.name = name;
      this.score = score;
      this.wins = wins;
      this.color = color;
      this.readyStatus = readyStatus;
    }

    public int getScore() {
<<<<<<< HEAD
      
      return score;
    
=======
      return score;
>>>>>>> origin/main
    } 
    
    public void addScore(int score) {
      
      this.score += score;
    
    } 

    public void setScore(int score) {
<<<<<<< HEAD

      this.score = score;

=======
      this.score = score;
>>>>>>> origin/main
    }

    public int getWins() {
<<<<<<< HEAD
      
      return wins;

=======
      return wins;
>>>>>>> origin/main
    }

    public void addWin() {

      wins++;

    }

    public void setWins(int wins) {
<<<<<<< HEAD

      this.wins = wins;
    
=======
      this.wins = wins;
>>>>>>> origin/main
    }

    public String getName() {
<<<<<<< HEAD

      return name;

=======
      return name;
>>>>>>> origin/main
    } 

    public void setName(String name) {
<<<<<<< HEAD

      this.name = name;

    }

    public String getColor() {

      return color;

    } 

    public void setColor(String color) {

      this.color = color;

    }

    public boolean getReady() {
        
      return readyStatus;

    } 
    public void setReady(boolean readyStatus) {

      this.readyStatus = readyStatus;

=======
      this.name = name;
    }
    public String getColor() {
      return color;
    } 
    public void setColor(String color) {
      this.color = color;
    }
    public boolean getReady() {
      return readyStatus;
    } 
    public void setReady(boolean input) {
      if(input){
        this.readyStatus = true;
      }
      else{
        this.readyStatus = false;
      }
>>>>>>> origin/main
    }

}

