package uta.cse3310;
import java.util.ArrayList;
import java.util.List;

public class InitialLobby {

    public PlayerType Players;
    public int NumOfPlayers = 1;
    // public PlayerType[] Button;
    public List<String> PlayerNames;

    InitialLobby() {
       
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

    public void Update(UserEvent U) {
        if (U.PlayerIdx != null && U.PlayerIdx.ordinal() < PlayerNames.size()) {
            PlayerNames.set(U.PlayerIdx.ordinal(), U.PlayerName); // Update player name in the list
        }
    }
}
