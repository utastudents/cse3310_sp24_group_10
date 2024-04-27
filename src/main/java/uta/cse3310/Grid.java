package uta.cse3310;
import java.util.ArrayList;

public class Grid {
  // Will this be called immediately on startup?  If so, a perfect place to read in the possible words
  char[][] board;

  public Grid(int id, ArrayList<String> words, int seed)
  {
    //public static char[][] createGrid(ArrayList<String> words, long seed)
    this.board = Generator.createGrid(words, seed);
  }



}
