package uta.cse3310;
// User events are sent from the webpage to the server

public class UserEvent {
    int PlayerIdx;
    int LobbyNum;
    boolean AddPlayer;
    int[] NumOfPlayersInLobby;
    int[] GameStarted;
    boolean Ready;
    String PlayerName; //name inputed by the player
    boolean MsgSent; //If a message has been sent
    String Msg; //chat message to be inputed by user
    boolean Surrender;
    boolean ScoreRequest; //If a update require request has been made
    int Score; //Score to be updated
    int X; //row cordinate
    int Y; //column cordinate
}
