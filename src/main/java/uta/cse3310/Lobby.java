package uta.cse3310;

public class Lobby {
    private Player ready;
    private static boolean player1ready = false;
    private static boolean player2ready = false;

    public void isReady(int playerID){
        /* Allow player to toggle their respective ready status */
        if(playerID == 1)
        {
            player1ready = !player1ready;
        }
        if(playerID==2)
        {
            player2ready = !player2ready;
        }
    }
    public boolean readyCheck(){
        retuen player1ready && player2ready; 
    }    

        
    }
    public int leave(){
        int leave = 0;
        return leave;
    }
/*
    public boolean readyCheck(){
        // Return true if all players are ready
        return true;
    }
*/
}

