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

public char grid[][];
public ArrayList<String> new words ArrayList<String>;


public class OnGoingGame extends WebSocketServer {
  public void initializeGrid(){
  }
  public void fillRandom(){
  }
  public void placeWords(){
  }
  public Boolean isWordFound(String word){
  }
  public void highlightWord(){
  }
  public void timer(){
  }
  public void update(){
  }
  public void surrender(){
  }
  public void backToLobby(){
  }
}

public static void main(String[] args){
}
