package uta.cse3310;
// User events are sent from the webpage to the server

public class UserEvent 
{
    int PlayerIdx;
    int LobbyNum;
    boolean AddPlayer;
    int[] NumOfPlayersInLobby;
    boolean Ready;
    String PlayerName; //name inputed by the player
    boolean MsgSent; //If a message has been sent
    String Msg; //chat message to be inputed by user
    boolean sortPlayers;
}
