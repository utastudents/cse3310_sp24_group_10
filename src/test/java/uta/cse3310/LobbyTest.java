package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uta.cse3310.InitialLobbyTest;
import uta.cse3310.Lobby;
import uta.cse3310.UserEvent;

//import static org.junit.Assert.assertArrayEquals;

public class LobbyTest  extends TestCase{

    public LobbyTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(InitialLobbyTest.class);
    }

    public void testReadyPlayer(){
        
        Lobby lobby1 = new Lobby(1);

        int[] ReadiedPlayers = {0, 1, 0, 0};

        UserEvent userEvent = new UserEvent();
        userEvent.PlayerIdx = 0;
        userEvent.Ready = true;

        lobby1.ReadyPlayer(userEvent);

        //assertArrayEquals(ReadiedPlayers, lobby1.ReadiedPlayers);

    }
    
}
