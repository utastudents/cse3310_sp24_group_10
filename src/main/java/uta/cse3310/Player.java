package uta.cse3310;

public class Player {
    String name;
    int score;
    int wins;

    Player(String name, int score, int wins){
      this.name = name;
      this.score = score;
      this.wins = wins;
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
    public void setReady(boolean input) {
      if(input){
        this.readyStatus = true;
      }
      else{
        this.readyStatus = false;
      }
    }

}

