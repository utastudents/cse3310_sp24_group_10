package uta.cse3310;

import org.junit.Test;
import static org.junit.Assert.*;

public class leavetest {
    public void testLeaveGame() {
        
        Game game = new Game();
        
        
        game.leaveGame();
        
        //verify player has left the game
        assertFalse(game.getPlayerIndexForWebSocket().contains("nickname")); // Assuming you have a method to check if the player is in the game
    }
}
