package uta.cse3310;
// User events are sent from the webpage to the server

public class UserEvent {
    int PlayerId;
    PlayerType PlayerIdx; // either an XPLAYER or an OPLAYER
    // int Button; // button number from 0 to 8
    String PlayerName; //name inputed by the player
}
