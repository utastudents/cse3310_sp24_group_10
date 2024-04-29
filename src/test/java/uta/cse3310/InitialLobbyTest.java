package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.Assert.assertArrayEquals;

public class InitialLobbyTest extends TestCase {

    public InitialLobbyTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(InitialLobbyTest.class);
    }

    // Test adding WebSocket connection with player index
    public void testAssociateWebSocketWithPlayer() {
        InitialLobby initialLobby = new InitialLobby();
        initialLobby.associateWebSocketWithPlayer(null, 1);
        assertEquals(1, initialLobby.getPlayerIndexForWebSocket(null));
    }

    // Test retrieving player index associated with WebSocket connection
    public void testGetPlayerIndexForWebSocket() {
        InitialLobby initialLobby = new InitialLobby();
        initialLobby.associateWebSocketWithPlayer(null, 2);
        assertEquals(2, initialLobby.getPlayerIndexForWebSocket(null));
    }

    // Test initialization of player names list
    public void testInitNames() {
        InitialLobby initialLobby = new InitialLobby();
        initialLobby.InitNames();
        assertNotNull(initialLobby.PlayerNamesInServer);
    }

    // Test updating player name at a specific index
    public void testUpdatePlayerName() {
        InitialLobby initialLobby = new InitialLobby();
        initialLobby.InitNames();
        initialLobby.updatePlayerName(0, "Player1");
        assertEquals("Player1", initialLobby.PlayerNamesInServer.get(0));
    }

    public void testUpdate() {
        // Create an InitialLobby instance
        InitialLobby lobby = new InitialLobby();
    
        // Initialize the lobby's player names
        lobby.InitNames();
    
        // Create a UserEvent to simulate adding a player with name "Fred" to lobby 1
        UserEvent addPlayerEvent = new UserEvent();
        addPlayerEvent.LobbyNum = 1;
        addPlayerEvent.PlayerIdx = 0;
        addPlayerEvent.PlayerName = "Fred";
        addPlayerEvent.AddPlayer = true;
    
        // Update the lobby with the addPlayerEvent
        lobby.Update(addPlayerEvent);
    
        // Verify that the NumOfPlayersInLobby was updated correctly
        assertArrayEquals(new int[]{1, 0, 0, 0, 0}, lobby.NumOfPlayersInLobby);
    }    
}
