package uta.cse3310;

public class Lobby {
    public PlayerType Players;
    public PlayerType CurrentTurn;
    public PlayerType[] Button;
    public int GameId;
    
    public void gameInfo(){
    }
    public void chatBox(){
    }
    public int leave(){
        int leave = 0;
        return leave;
    }
    public void toggleReady(){
        /* Allow player to toggle their respective ready status */
    }
    public boolean readyCheck(){
        /* Return true if all players are ready */
    }
}
