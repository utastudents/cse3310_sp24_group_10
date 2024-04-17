package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    public int LobbyNum;
    public List<Player> players;
    public int[] PlayerIds = new int[] {-1, -1, -1, -1};
    public int[] ReadiedPlayers = new int[] {0, 0, 0, 0};

    public Lobby(int lobbyNum) {
        this.LobbyNum = lobbyNum; // Initialize LobbyNum with the parameter
        players = new ArrayList<>();
    }

    /* Create an array list to store the players of each lobby*/
    ArrayList<Player> PlayersInLobby = new ArrayList<>(4); 

    public void StartGame(){
        System.out.println("GAME HAS BEEN STARTED!!!!!!!!!!!!!!!!!");
    }
    
    public void AddPlayers(UserEvent U) {
        Player newPlayer = new Player(U.PlayerName, 0,0);

        // players.add(U.PlayerName);
        PlayersInLobby.add(newPlayer);
        for(int i = 0; i < 4; i++)
        {
            if(PlayerIds[i] == -1)
            {
                PlayerIds[i] = U.PlayerIdx;
                break;
            }
        }
        System.out.println("PLAYER SUCCESFULLY ADDED");
    }

    public void ReadyPlayer(UserEvent U) {
        for(int j = 0; j < 4; j++)
        {
            if(U.PlayerIdx == PlayerIds[j])
            {
                ReadiedPlayers[j] = 1;
                int count = 0;
                for(int i = 0; i < 4; i++)
                {
                    if(ReadiedPlayers[i] == 1)
                    {
                        count++;
                        if((count == players.size()) && (count <= 2))
                        {
                            StartGame();
                        }
                    }
                }
                break;
            }
        }
    }
    public void sortPlayers() 
    {
        PlayerComparator comparator = new PlayerComparator();
        List<Player> sortedPlayers = comparator.sortPlayers(players);
    }

    // String sortedPlayersJson = gson.toJson(players);
    // broadcast(sortedPlayersJson);
}
