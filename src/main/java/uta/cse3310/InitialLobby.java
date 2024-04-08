package uta.cse3310;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.java_websocket.WebSocket;

public class InitialLobby {

    public PlayerType Players;
    public int NumOfPlayers = 1;
    public int NumOfPlayersInLobby;
    public List<String> PlayerNames;
    public Map<WebSocket, Integer> connectionToPlayerIndexMap;

    Lobby Lobby1 = null;
    Lobby Lobby2 = null;
    Lobby Lobby3 = null;
    Lobby Lobby4 = null;


    InitialLobby() {
        connectionToPlayerIndexMap = new HashMap<>();
        Lobby1 = new Lobby();
    }

    // Method to associate WebSocket connection with player index
    public void associateWebSocketWithPlayer(WebSocket conn, int playerIndex) {
        connectionToPlayerIndexMap.put(conn, playerIndex);
    }

    // Method to retrieve player index associated with WebSocket connection
    public int getPlayerIndexForWebSocket(WebSocket conn) {
        return connectionToPlayerIndexMap.getOrDefault(conn, -1);
    }

    public void InitNames(){
        PlayerNames = new ArrayList<>(); // Initialize as ArrayList
        for (int i = 0; i < 20; i++) { // Assuming a lobby can have up to 20 players
            PlayerNames.add(""); // Add empty string to the list
        }
    }

    public void StartInitialLobby() {
        // Any initialization logic you want to perform when starting the lobby
    }

    public int PlayerToIdx() {
        int idx = -1;
        for (int i = 0; i < PlayerNames.size(); i++) {
            // Check if the current player's name is empty
            if (PlayerNames.get(i).isEmpty()) {
                // Update name so its not found in loop again.
                PlayerNames.set(i, "WaitingForName");
                idx = i;
                break;
            }
        }
        return idx;
    }

    public int getPlayerIdx(WebSocket conn) {
        // Retrieve the string representation of the WebSocket connection
        String connString = conn.toString();
        System.out.println("WebSocket connection string: " + connString);

        // Iterate through the list of player names and find the index associated with the connection
        for (int i = 0; i < PlayerNames.size(); i++) {
            System.out.println("Player name at index " + i + ": " + PlayerNames.get(i));
            if (PlayerNames.get(i).equals(connString)) {
                return i;
            }
        }
        return -1; // If the player index is not found
    }

    

    public void updatePlayerName(int playerIdx, String newName) {
        // Update the player's name at the specified index
        PlayerNames.set(playerIdx, newName);
    }

    public void Update(UserEvent U) {
        //set player names
        if(U.LobbyNum == 0)
        {
            PlayerNames.set(U.PlayerIdx, U.PlayerName);
        }

        if(U.LobbyNum != 0)
        {
            System.out.println("CHOOSING LOBBY NOW");
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.AddPlayers(U);
                    this.NumOfPlayersInLobby++; // Increment the global variable
                    System.out.println("JOINED LOBBY1");
                    break;
                case 2:
                    Lobby2.AddPlayers(U);
                    break;
                case 3:
                    Lobby3.AddPlayers(U);
                    break;
                case 4:
                    Lobby4.AddPlayers(U);
                    break;
                default:
                    System.out.println("NO LOBBY FOUND");
            }
        }
    }
}
