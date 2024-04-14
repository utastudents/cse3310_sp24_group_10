package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    public List<String> PlayerNames;
    public int[] PlayerIds = new int[] {-1, -1, -1, -1};
    public int[] ReadiedPlayers = new int[] {0, 0, 0, 0};
    Lobby() {
        PlayerNames = new ArrayList<>();
    }

    public void StartGame(){
        System.out.println("GAME HAS BEEN STARTED!!!!!!!!!!!!!!!!!");
    }
    
    public void AddPlayers(UserEvent U) {
        PlayerNames.add(U.PlayerName);
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
                        if(count == PlayerNames.size() && count <= 2)
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
