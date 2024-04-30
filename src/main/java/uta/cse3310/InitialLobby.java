package uta.cse3310;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.java_websocket.WebSocket;
import java.util.Optional;

public class InitialLobby {

    public PlayerType Players;
    public int NumOfPlayers = 1;
    public int[] NumOfPlayersInLobby = {0, 0, 0, 0, 0};
    
    public List<String> PlayerNamesInServer;
    public Map<WebSocket, Integer> connectionToPlayerIndexMap;
    // Players in each lobby
    List<String[]> L1PlayerNames = new ArrayList<>();
    List<String[]> L2PlayerNames = new ArrayList<>();
    List<String[]> L3PlayerNames = new ArrayList<>();
    List<String[]> L4PlayerNames = new ArrayList<>();
    List<String[]> L5PlayerNames = new ArrayList<>();


    /* Game lobbies  */
    Lobby Lobby1 = null;
    Lobby Lobby2 = null;
    Lobby Lobby3 = null;
    Lobby Lobby4 = null;
    Lobby Lobby5 = null;

    String version = "not found";

    InitialLobby() {

        // Takes in envoriment variable as a string.  If VERSION is not given, uses empty string
        version = Optional.ofNullable(System.getenv("VERSION")).orElse("");

        connectionToPlayerIndexMap = new HashMap<>();
        /* Create new lobby objects */
        Lobby1 = new Lobby(1);
        Lobby2 = new Lobby(2);
        Lobby3 = new Lobby(3);
        Lobby4 = new Lobby(4);
        Lobby5 = new Lobby(5);
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
        PlayerNamesInServer = new ArrayList<>(); // Initialize as ArrayList
        for (int i = 0; i < 20; i++) { // Assuming a lobby can have up to 20 players
            PlayerNamesInServer.add(""); // Add empty string to the list
        }
    }

    public void StartInitialLobby() {
        // Any initialization logic you want to perform when starting the lobby
    }

    public int PlayerToIdx() {
        int idx = -1;
        for (int i = 0; i < PlayerNamesInServer.size(); i++) {
            // Check if the current player's name is empty
            if (PlayerNamesInServer.get(i).isEmpty()) {
                // Update name so its not found in loop again.
                PlayerNamesInServer.set(i, "WaitingForName");
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
        for (int i = 0; i < PlayerNamesInServer.size(); i++) {
            System.out.println("Player name at index " + i + ": " + PlayerNamesInServer.get(i));
            if (PlayerNamesInServer.get(i).equals(connString)) {
                return i;
            }
        }
        return -1; // If the player index is not found
    }

    

    public void updatePlayerName(int playerIdx, String newName) {
        // Update the player's name at the specified index
        PlayerNamesInServer.set(playerIdx, newName);
    }

    public int getLobbyNum(int playerIdx){
        int lobbyNum = -1;
        
        int[] L1PlayerIds = Lobby1.getPlayerIds();
        int[] L2PlayerIds = Lobby1.getPlayerIds();
        int[] L3PlayerIds = Lobby1.getPlayerIds();
        int[] L4PlayerIds = Lobby1.getPlayerIds();
        int[] L5PlayerIds = Lobby1.getPlayerIds();

        if(searchLobby(playerIdx, L1PlayerIds))
            lobbyNum = 1;
        else if(searchLobby(playerIdx, L2PlayerIds))
            lobbyNum = 2;
        else if(searchLobby(playerIdx, L3PlayerIds))
            lobbyNum = 3;
        else if(searchLobby(playerIdx, L4PlayerIds))
            lobbyNum = 4;
        else if(searchLobby(playerIdx, L5PlayerIds))
            lobbyNum = 5;
        else
            System.out.println("LOBBY NUM NOT FOUND");
        return lobbyNum;
    }

    public boolean searchLobby(int playerIdx, int[] LPlayerIds){
        for(int i = 0; i < 4; i++)
        {
            if(playerIdx == LPlayerIds[i])
            {
                return true;
            }
        }
        return false;
    }
    
    public String searchNames(int playerIdx, List<String> playerNames, int[] playerIds){
        String name = "";
        for(int i = 0; i < 4; i++)
        {
            if(playerIds[i] == playerIdx)
            {
                name = playerNames.get(i);
            }
        }
        return name;
    }

    public String getPlayerNameFromLobby(int lobbyNum, int playerIdx){
        List<String> playerNames;
        int[] playerIds;
        String name = "";
        switch(lobbyNum)
        {
            case 1:
                playerNames = Lobby1.getPlayerNames();
                playerIds = Lobby1.getPlayerIds();
                name = searchNames(playerIdx, playerNames, playerIds);
                break;
            case 2:
                playerNames = Lobby2.getPlayerNames();
                playerIds = Lobby2.getPlayerIds();
                name = searchNames(playerIdx, playerNames, playerIds);
                break;
            case 3:
                playerNames = Lobby3.getPlayerNames();
                playerIds = Lobby3.getPlayerIds();
                name = searchNames(playerIdx, playerNames, playerIds);
                break;
            case 4:
                playerNames = Lobby4.getPlayerNames();
                playerIds = Lobby4.getPlayerIds();
                name = searchNames(playerIdx, playerNames, playerIds);
                break;
            case 5:
                playerNames = Lobby5.getPlayerNames();
                playerIds = Lobby5.getPlayerIds();
                name = searchNames(playerIdx, playerNames, playerIds);
                break;
        }
        return name;
    }

    public void Update(UserEvent U) {
        //set player names
        if(U.LobbyNum == 0)
        {
            PlayerNamesInServer.set(U.PlayerIdx, U.PlayerName);
        }

        if(U.AddPlayer)
        {
            System.out.println("\nCHOOSING LOBBY NOW");
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.AddPlayers(U);
                    this.NumOfPlayersInLobby[0]++; // Increment the global variable
                    System.out.println("JOINED LOBBY1\n");
                    break;
                case 2:
                    Lobby2.AddPlayers(U);
                    this.NumOfPlayersInLobby[1]++;
                    break;
                case 3:
                    Lobby3.AddPlayers(U);
                    this.NumOfPlayersInLobby[2]++;
                    break;
                case 4:
                    Lobby4.AddPlayers(U);
                    this.NumOfPlayersInLobby[3]++;
                    break;
                case 5:
                    Lobby5.AddPlayers(U);
                    this.NumOfPlayersInLobby[4]++;
                    break;
                default:
                    System.out.println("NO LOBBY FOUND");
            }
        }
        if(true){
            /* Update ready state */
            System.out.println("\nREADY BUTTON CLICKED");
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.ReadyPlayer(U);
                    break;
                case 2:
                    Lobby2.ReadyPlayer(U);
                    break;
                case 3:
                    Lobby3.ReadyPlayer(U);
                    break;
                case 4:
                    Lobby4.ReadyPlayer(U);
                    break;
                case 5:
                    Lobby5.ReadyPlayer(U);
                    break;
                default:
                    System.out.println("NO LOBBY FOUND TO READY UP\n");
            }
        }
        if(U.MsgSent){
            System.out.println("\nMESSAGE SENT. UPDATING CHAT LOGS\n");
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.Chatting(U);
                    break;
                case 2:
                    Lobby2.Chatting(U);
                    break;
                case 3:
                    Lobby3.Chatting(U);
                    break;
                case 4:
                    Lobby4.Chatting(U);
                    break;
                case 5:
                    Lobby5.Chatting(U);
                    break;
                default:
                    System.out.println("NO LOBBY FOUND TO UPDATE CHAT LOGS\n");
            }
        }
        if(U.Surrender){
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.SurrenderPlayer(U);
                    this.NumOfPlayersInLobby[0]--;
                    break;
                case 2:
                    Lobby2.SurrenderPlayer(U);
                    this.NumOfPlayersInLobby[1]--;
                    break;
                case 3:
                    Lobby3.SurrenderPlayer(U);
                    this.NumOfPlayersInLobby[2]--;
                    break;
                case 4:
                    Lobby4.SurrenderPlayer(U);
                    this.NumOfPlayersInLobby[3]--;
                    break;
                case 5:
                    Lobby5.SurrenderPlayer(U);
                    this.NumOfPlayersInLobby[4]--;
                    break;
                default:
                    System.out.println("NOT ABLE TO SURRENDER\n");
            }
        }
        if(U.ScoreRequest){
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.modScore(U, NumOfPlayersInLobby[0]);
                    break;
                case 2:
                    Lobby2.modScore(U, NumOfPlayersInLobby[1]);
                    break;
                case 3:
                    Lobby3.modScore(U, NumOfPlayersInLobby[2]);
                    break;
                case 4:
                    Lobby4.modScore(U, NumOfPlayersInLobby[3]);
                    break;
                case 5:
                    Lobby5.modScore(U, NumOfPlayersInLobby[4]);
                    break;
                default:
                    System.out.println("NO LOBBY FOUND TO READY UP\n");
            }
        }
        if(true){
            switch(U.LobbyNum)
            {
                case 1:
                    Lobby1.sortByScore();
                    break;
                case 2:
                    Lobby2.sortByScore();
                    break;
                case 3:
                    Lobby3.sortByScore();
                    break;
                case 4:
                    Lobby4.sortByScore();
                    break;
                case 5:
                    Lobby5.sortByScore();
                    break;
                default:
                    System.out.println("NO LOBBY FOUND TO SORT PLAYER LIST\n");
            }
        }
    }
}
