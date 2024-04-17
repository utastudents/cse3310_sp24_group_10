package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    public int LobbyNum;
    public List<String> PlayerNames;
    public int[] PlayerIds = new int[] {-1, -1, -1, -1};
    public int[] ReadiedPlayers = new int[] {0, 0, 0, 0};

    public Lobby(int lobbyNum) {
        this.LobbyNum = lobbyNum; // Initialize LobbyNum with the parameter
        PlayerNames = new ArrayList<>();
    }

    /* Create an array list to store the players of each lobby*/
    ArrayList<Player> PlayersInLobby = new ArrayList<>(4); 

    public void StartGame(){
        System.out.println("GAME HAS BEEN STARTED!!!!!!!!!!!!!!!!!");
    }
    
    public void AddPlayers(UserEvent U) {
        Player newPlayer = new Player(U.PlayerName, 0,0); //Create a profile for the new player

        PlayerNames.add(U.PlayerName);
        PlayersInLobby.add(newPlayer); //add the new profile to the array of players in the lobby
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
                System.out.println(U.PlayerIdx+ "is: "+U.Ready);
                if(U.Ready == true){
                    ReadiedPlayers[j] = 1;
                    System.out.println("PLAYER READIED");
                }
                else if(U.Ready == false){ //attempt to reset ready state to 0
                    ReadiedPlayers[j] = 0;
                    System.out.println("PLAYER UNREADIED");
                }

                int count = 0;
                for(int i = 0; i < 4; i++)
                {
                    if(ReadiedPlayers[i] == 1)
                    {
                        count++;
                        if((count == PlayerNames.size()) && (count <= 2))
                        {
                            StartGame();
                        }
                    }
                }
                break;
            }
        }
    }
}
