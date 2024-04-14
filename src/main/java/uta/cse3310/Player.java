package uta.cse3310;

public class Player {

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

    public int getScore() {
      
      return score;
    
    } 
    
    public void addScore(int score) {
      
      this.score += score;
    
    } 

    public void setScore(int score) {

      this.score = score;

    }

    public int getWins() {
      
      return wins;

    }

    public void addWin() {

      wins++;

    }

    public void setWins(int wins) {

      this.wins = wins;
    
    }

    public String getName() {

      return name;

    } 

    public void setName(String name) {

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

    }

}

