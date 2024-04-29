package uta.cse3310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

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


public class App extends WebSocketServer {

  // Vector<InitialLobby> ActiveIL = new Vector<InitialLobby>();

  InitialLobby IL = null;

  int numOfPlayers = 1;
  int extraPlayers = 0;
  static public ArrayList<String> words = new ArrayList<>();
  
  public App(int port) {
    super(new InetSocketAddress(port));
    this.setReuseAddr(true); // Forcing the reuse of ports on timeout
  }

  public App(InetSocketAddress address) {
    super(address);
  }

  public App(int port, Draft_6455 draft) {
    super(new InetSocketAddress(port), Collections.<Draft>singletonList(draft));
  }

  @Override
  public void onOpen(WebSocket conn, ClientHandshake handshake) {

    System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " connected");

    ServerEvent E = new ServerEvent();

    // search for a Initial Lobby needing a player
    if (IL != null &&  numOfPlayers <= 20) {
      IL.NumOfPlayers = numOfPlayers;
      numOfPlayers++;
      System.out.println("Found a match");
    } else if(IL == null) {
      // No matches or lobby is full, create a new lobby
      IL = new InitialLobby();
      IL.NumOfPlayers = numOfPlayers;
      numOfPlayers++;
      IL.InitNames();
      IL.StartInitialLobby();
      System.out.println("Creating a new InitialLobby");
    }
    else {
      extraPlayers++;
      System.out.println("Initial lobby full");
    }

    int idx = IL.PlayerToIdx();

    E.NumOfPlayers = IL.NumOfPlayers;
    E.PlayerIdx = idx;

    IL.associateWebSocketWithPlayer(conn, idx);

    // allows the websocket to give us the Game when a message arrives
    conn.setAttachment(IL);

    Gson gson = new Gson();
    // Note only send to the single connection
    conn.send(gson.toJson(E));
    System.out.println(gson.toJson(E));

    // The state of the game has changed, so lets send it to everyone
    String jsonString;
    jsonString = gson.toJson(IL);
    // Send lobby specific word grid to all it's players

    System.out.println(jsonString);
    broadcast(jsonString);
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println(conn + " has closed");

    // Retrieve the game tied to the WebSocket connection
    InitialLobby IL = conn.getAttachment();

    // Retrieve the player index associated with the WebSocket connection
    int playerIdx = IL.getPlayerIndexForWebSocket(conn);
    int lobbyNum = IL.getLobbyNum(playerIdx);
    String name = IL.getPlayerNameFromLobby(lobbyNum, playerIdx);

    if (playerIdx != -1) {
      
      // Create a UserEvent indicating that the player has surrendered
      UserEvent surrenderEvent = new UserEvent();
      surrenderEvent.Surrender = true;
      surrenderEvent.PlayerIdx = playerIdx;
      surrenderEvent.PlayerName = name;
      surrenderEvent.LobbyNum = lobbyNum;

      // Call the Update method of InitialLobby with the surrender event
      IL.Update(surrenderEvent);

      // Set the player's name to an empty string
      IL.updatePlayerName(playerIdx, "");

      System.out.println("Player disconnected: " + playerIdx);
    } else {
        System.out.println("Player index not found.");
    }

    //Decrease amount of players
    if(extraPlayers > 0)
    {
      extraPlayers--;
    }
    else
    {
      numOfPlayers--;
    }
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    System.out.println(conn + ": " + message);

    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    
    // Debugging: Print received JSON message
    System.out.println("Received JSON message: " + message);

    UserEvent U = gson.fromJson(message, UserEvent.class);

    InitialLobby IL = conn.getAttachment();
    IL.Update(U);

    //State of the game has changed so send it to everyone
    String jsonString = gson.toJson(IL);
    System.out.println(jsonString);
    broadcast(jsonString);
  }

  @Override
  public void onMessage(WebSocket conn, ByteBuffer message) {
    System.out.println(conn + ": " + message);
  }

  @Override
  public void onError(WebSocket conn, Exception ex) {
    ex.printStackTrace();
    if (conn != null) {
      // some errors like port binding failed may not be assignable to a specific
      // websocket
    }
  }

  @Override
  public void onStart() {
    System.out.println("Server started!");
    setConnectionLostTimeout(0);
  }

  public static void main(String[] args) {

    // Set up the http server
    int WEBSOCKET_PORT = 9010;
    HttpServer H = new HttpServer(WEBSOCKET_PORT, "./html");
    H.start();
    System.out.println("http Server started on port:" + WEBSOCKET_PORT);

    // create and start the websocket server

    WEBSOCKET_PORT = 9110;
    App A = new App(WEBSOCKET_PORT);
    A.start();
    System.out.println("websocket Server started on port: " + WEBSOCKET_PORT);

  }
}
