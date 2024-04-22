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
    public int getWins() {
      return wins;
    }
    public String getName() {
      return name;
    }
}

