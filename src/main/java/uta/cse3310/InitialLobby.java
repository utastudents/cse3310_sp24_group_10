package uta.cse3310;

public class InitialLobby {
    private int gameID;
    public static int totalGames; //increments and decrements
    public int playerSize; //dependent on button clicked
    public PlayerType player;
   
    public int getGameID(){
        /* Getter for gameID; Necessary for Game Lobby*/
        return this.gameID;
    }
    public void setGameID(int gameID){
        /* Setter for gameID */
        this.gameID = gameID;
    }
   
    public void updateDisplayName(String nickname){
        /* Update the player instance calling the method */
        /* Code to modify current player */
    }
    public int createLobby(int playerSize){
        /* Compare totalGames w/ 5 */
        /* Create gameID (by setter)*/
        /* Code to establish a game lobby here */
        return getGameID();
    }
    public void joinLobby(int gameID){
        /* Use gameID as reference point to join a lobby */
        /* Code for player to be associated with Game Lobby; joining lobby */
    }
    public boolean compareID(){
       return true;
    }
}
