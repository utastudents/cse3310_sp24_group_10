package uta.cse3310;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Lobby 
{

    public List<Player> players;
    public int[] PlayerIds = new int[] {-1, -1, -1, -1};
    public int[] ReadiedPlayers = new int[] {0, 0, 0, 0};
    Lobby() 
    {
        players = new ArrayList<>();
    }

    public void StartGame()
    {
        System.out.println("GAME HAS BEEN STARTED!!!!!!!!!!!!!!!!!");
    }
    
    public void AddPlayers(Player player) 
    {
        players.add(player);
        for(int i = 0; i < 4; i++)
        {
            if(PlayerIds[i] == -1)
            {
                PlayerIds[i] = player.getId();
                break;
            }
        }
        System.out.println("PLAYER SUCCESFULLY ADDED");
    }

    public void ReadyPlayer(Player player) 
    {
        for(int j = 0; j < 4; j++)
        {
            if(player.getId() == PlayerIds[j])
            {
                ReadiedPlayers[j] = 1;
                int count = 0;
                for(int i = 0; i < 4; i++)
                {
                    if(ReadiedPlayers[i] == 1)
                    {
                        count++;
                        if(count == players.size() && count <= 2)
                        {
                            StartGame();
                        }
                    }
                }
                break;
            }
        }
    }

    public void leaderboard() 
    {
        Collections.sort(players, (p1, p2) -> p2.getWins() - p1.getWins());
    
        displayPlayers(players);
    }
    
    public void leaderboardingame() 
    {
        Collections.sort(players, (p1, p2) -> p2.score - p1.score);

        displayPlayers(players);
    }

    public static void displayPlayers(List<Player> players) 
    {
        int rank = 1;
        for (Player player : players) 
        {
            System.out.println(rank + ". " + player.name + " - " + player.wins);
            rank++;
        }
    }   
}
