package uta.cse3310;
// User events are sent from the webpage to the server

public class UserEvent {
    public int PlayerIdx;
    public String PlayerName; //name inputed by the player
    public int LobbyNum;
    public boolean AddPlayer;
    public int[] NumOfPlayersInLobby;
    public boolean Ready;
}
