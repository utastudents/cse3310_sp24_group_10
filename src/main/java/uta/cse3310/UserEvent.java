package uta.cse3310;
// User events are sent from the webpage to the server

public class UserEvent {
    int PlayerIdx;
    int LobbyNum;
    int[] NumOfPlayersInLobby;

    String PlayerName; //name inputed by the player
    String PlayerScore;
    String PlayerWins;
    String PlayerColor;
    String PlayerStatus;

    Player player; //Player information

    public void statToString(){
        PlayerScore = Integer.toString(player.getScore());
        PlayerWins = Integer.toString(player.getWins());
        PlayerColor = player.getColor();
        PlayerStatus = Boolean.toString(player.getReady());
    }
}
