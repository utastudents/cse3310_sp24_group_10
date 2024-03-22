package uta.cse3310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;

import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class InitialLobby extends WebSocketServer{
    public static int totalGames; //increments and decrements
    private int gameID;
    public Player player;
    //public int playerSize; //dependent on button clicked

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
    }

    @Override
    public void onStart() {
    }
    
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
