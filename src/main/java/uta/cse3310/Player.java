package uta.cse3310;

public class Player {
    String name;
    int score;
    int wins;
    String color;
    boolean readyStatus;

    Player(String name, int score, int wins, String color, boolean readyStatus){
      this.name = name;
      this.score = score;
      this.wins = wins;
      this.color = color;
      this.readyStatus = readyStatus;
    }

    public int getScore() {
      return score;
    } 
    public void setScore(int score) {
      this.score = score;
    }
    public int getWins() {
      return wins;
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
    public void setReady(boolean input) {
      if(input){
        this.readyStatus = true;
      }
      else{
        this.readyStatus = false;
      }
    }

}

