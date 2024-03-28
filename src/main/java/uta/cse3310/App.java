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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class App extends WebSocketServer {

  InitialLobby L = null;

  int numOfPlayers = 1;
  int extraPlayers = 0;
  
  public App(int port) {
    super(new InetSocketAddress(port));
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

    // search for a game needing a player
    if (L != null && L.Players == uta.cse3310.PlayerType.PLAYERL && numOfPlayers < 4) {
      L.NumOfPlayers = numOfPlayers;
      L.Players = uta.cse3310.PlayerType.PLAYERL;
      numOfPlayers++;
      System.out.println("Found a match");
    } else if(L == null) {
      // No matches or lobby is full, create a new lobby
      L = new InitialLobby();
      L.Players = uta.cse3310.PlayerType.PLAYERL;
      L.NumOfPlayers = numOfPlayers;
      numOfPlayers++;
      System.out.println("Creating a new InitialLobby");
    }
    else {
      extraPlayers++;
      System.out.println("Initial lobby full");
    }

    E.NumOfPlayers = L.NumOfPlayers;

    // allows the websocket to give us the Game when a message arrives
    conn.setAttachment(L); // was G

    Gson gson = new Gson();
    // Note only send to the single connection
    conn.send(gson.toJson(E));
    System.out.println(gson.toJson(E));

    // The state of the game has changed, so lets send it to everyone
    String jsonString;
    jsonString = gson.toJson(L); // was G

    System.out.println(jsonString);
    broadcast(jsonString);
  }

  @Override
  public void onClose(WebSocket conn, int code, String reason, boolean remote) {
    System.out.println(conn + " has closed");
    // Retrieve the game tied to the websocket connection
    InitialLobby L = conn.getAttachment();
    L = null;
    if(extraPlayers > 0)
    {
      extraPlayers--;
    }
    else{
      numOfPlayers--;
    }
  }

  @Override
  public void onMessage(WebSocket conn, String message) {
    System.out.println(conn + ": " + message);

    // Bring in the data from the webpage
    // A UserEvent is all that is allowed at this point
    GsonBuilder builder = new GsonBuilder();
    Gson gson = builder.create();
    UserEvent U = gson.fromJson(message, UserEvent.class);
    System.out.println(U.Button);

    // Get our InitialLobby Object
    InitialLobby L = conn.getAttachment();
    L.Update(U);

    // send out the game state every time
    // to everyone
    String jsonString;
    jsonString = gson.toJson(L);

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
    int port = 9080;
    HttpServer H = new HttpServer(port, "./html");
    H.start();
    System.out.println("http Server started on port:" + port);

    // create and start the websocket server

    port = 9880;
    App A = new App(port);
    A.start();
    System.out.println("websocket Server started on port: " + port);

  }
}