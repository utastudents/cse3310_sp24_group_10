package uta.cse3310;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.Optional;

public class Lobby {

  public int LobbyNum;
  public List<String> PlayerNames;
  public int[] PlayerIds = new int[] {-1, -1, -1, -1};
  public int[] ReadiedPlayers = new int[] {0, 0, 0, 0};
  public int[] PlayerScores = new int[] {0, 0, 0, 0};
  public int[] PlayerWins = new int[] {0, 0, 0, 0};
  public int GameStarted = 0;
  public long rand_num = 0;
  public ArrayList<String> words = new ArrayList<>(Arrays.asList("aaron----"));
  public char[][] board;
  private final boolean debug = true;

  public Lobby(int lobbyNum) {
    this.LobbyNum = lobbyNum; // Initialize LobbyNum with the parameter
    PlayerNames = new ArrayList<>();

    // Takes in envoriment variable as a string.  If TEST_GRID is not given, uses empty string
    String seed = Optional.ofNullable(System.getenv("TEST_GRID")).orElse("");

    if (debug)
    {
      System.out.format("TEST_GRID value: '%s'\n", seed);
    }
    Random rand_num;
    // Check if TEST_GRID is defined
    if (seed.isEmpty())
    {
      // Use a random seed
      rand_num = new Random();
    } else
    {
      // Use TEST_GRID as the seed
      rand_num = new Random(Long.valueOf(seed));
    }
    // Creates the random number to be passed to the board generator
    long board_seed = rand_num.nextLong(100000);

    if (debug)
    {
      System.out.format("rand_num: %d\n", board_seed);
    }
    Generator.initWords();
    board = Generator.createGrid(words, board_seed);
  }

  public int getLobbyNum(){
    return LobbyNum;
  }

  public List<String> getPlayerNames(){
    return PlayerNames;
  }

  public int[] getPlayerIds(){
    return PlayerIds;
  }

  /* Create an array list to store the players of each lobby*/
  ArrayList<Player> PlayersInLobby = new ArrayList<>(4); 

  Chat chatLog = new Chat();

  public void StartGame(){
    System.out.println("GAME HAS BEEN STARTED!!!!!!!!!!!!!!!!!");
    GameStarted = 1;
  }

  public void AddPlayers(UserEvent U) {
    Player newPlayer = new Player(U.PlayerName, 0,0); //Create a profile for the new player
    PlayerNames.add(U.PlayerName);
    PlayersInLobby.add(newPlayer); //add the new profile to the array of players in the lobby
    for(int i = 0; i < 4; i++)
    {
      if(PlayerIds[i] == -1)
      {
        PlayerIds[i] = U.PlayerIdx;
        break;
      }
    }
    System.out.println("PLAYER SUCCESFULLY ADDED");
  }

  public void ReadyPlayer(UserEvent U) {
    for(int j = 0; j < 4; j++)
    {
      if(U.PlayerIdx == PlayerIds[j])
      {
        if(U.Ready == true){
          ReadiedPlayers[j] = 1;
          System.out.println("PLAYER READIED");
        }
        else if(U.Ready == false){ //attempt to reset ready state to 0
          ReadiedPlayers[j] = 0;
          System.out.println("PLAYER UNREADIED");
        }

        int count = 0;
        for(int i = 0; i < 4; i++)
        {
          if(ReadiedPlayers[i] == 1)
          {
            count++;
            if((count == PlayerNames.size()) && (count <= 2))
            {
              StartGame();
            }
          }
        }
        break;
      }
    }
  }

  public void Chatting(UserEvent U){
    String text = U.Msg;
    System.out.println("\nDEBUG: Msg = "+text);
    chatLog.addMessage(text);
  }

  public void SurrenderPlayer(UserEvent U)
  {
    PlayerNames.remove(U.PlayerName);
    System.out.println("\nPLAYER NAME REMOVED;");

    for (int i = 0; i < PlayersInLobby.size(); i++) 
    {
      if (PlayersInLobby.get(i).name.equals(U.PlayerName)) 
      {
        PlayersInLobby.remove(i);
        System.out.println("\nPLAYER OBJECT REMOVED");
        break;
      }
    }

    for(int i = 0; i < 4; i++)
    {
      if(PlayerIds[i] == U.PlayerIdx)
      {
        PlayerIds[i] = -1;
        System.out.println("\nPLAYER ID REMOVED");
        break;
      }
    }
    System.out.println("PLAYER SURRENDERED");
  }
  /* This func updates the scores */
  public void modScore(UserEvent U, int num){
    for(int i = 0; i < num; i++){
      /* Update the array list of player information*/
      Player tempPlayer = PlayersInLobby.get(i);
      if(U.PlayerName.equals(tempPlayer.getName())){
        tempPlayer.setScore(U.Score);
        PlayersInLobby.set(i, tempPlayer);
      }
      /* Update the score list */
      if(U.PlayerIdx == PlayerIds[i]){
        PlayerScores[i] = U.Score;
      }
    }
  }
  //This function will sort the arraylist
  public void sortByScore(){
    Collections.sort(PlayersInLobby, new sortScores());
  }
}
/* A class to sort the Array List of players by Score */
class sortScores implements Comparator<Player>{
  public int compare(Player p1, Player p2){
    return p2.score - p1.score; //update this to change sorting order
  }
}
