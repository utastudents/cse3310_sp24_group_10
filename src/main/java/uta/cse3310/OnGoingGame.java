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


public class OnGoingGame extends WebSocketServer {

    private char[][] grid = new char[50][50];
    private ArrayList<String> words = new ArrayList<String>();
  
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

    public void initializeGrid(){

    }

    public void fillRandom(){

    }

    public void placeWords(){

    }

    public Boolean isWordFound(String word){
        boolean wordFound = false;
        return wordFound;
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


