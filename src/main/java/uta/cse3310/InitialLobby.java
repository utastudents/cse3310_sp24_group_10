package uta.cse3310;

public class InitialLobby {
    public static int totalGames; //increments and decrements
    private int gameID;
    public Player player;
    //public int playerSize; //dependent on button clicked
   
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
        /* Compare gameID to check if there is availability (Max 5 concurrent games) */
       return true;
    }
    public void displayLeaderboard(){
        /* Here would display the server leaderboard */
    }
    public void sortLeaderboard(){
        /* Event-driven leaderboard sort */
        /* Should be called after every game conclusion */
    }
    public void leaveServer(){
        /* Allows player to leave the SERVER (different from leaving the in-game lobby) */
    }
    
    public static void main(String[] args){

    }
}
