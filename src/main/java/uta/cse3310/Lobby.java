package uta.cse3310;

import java.util.ArrayList;
import java.util.List;

public class Lobby {

    public List<String> PlayerNames;
    Lobby(){
        PlayerNames = new ArrayList<>();
    }
    
    public void AddPlayers(UserEvent U){
        PlayerNames.add(U.PlayerName);
        System.out.println("PLAYER SUCCESFULLY ADDED");
    }
}
