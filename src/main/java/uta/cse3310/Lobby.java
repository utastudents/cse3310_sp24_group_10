package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Lobby {
    
    ArrayList<Player> PlayersInLobby = new ArrayList<>();

    public void AddPlayers(UserEvent U){
        Player newPlayer = new Player(U.PlayerName, 0, 0, "color", false);

        PlayersInLobby.add(newPlayer);
        System.out.println("PLAYER SUCCESFULLY ADDED");
    }
}
