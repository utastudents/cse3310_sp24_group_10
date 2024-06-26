package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uta.cse3310.InitialLobbyTest;
import uta.cse3310.Lobby;
import uta.cse3310.UserEvent;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

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

        assertArrayEquals(ReadiedPlayers, lobby1.ReadiedPlayers);
    }

    /*
     * This tests if the var newTestPlayer asserts the correct information given parmeters
     * during creation 
     */
    public void testPlayerCreation(){ //extending from Lobby.java
        /* Create players of different types */
        String p1Name = "Billy";
        String p2Name = "";
        String p3Name = "John@^123";

        Player newTestPlayer1 = new Player(p1Name, 0, 0); //As intended
        Player newTestPlayer2 = new Player(p2Name, 1, 2);//Blank name :: nonzero numbers
        Player newTestPlayer3 = new Player(p3Name, 1000000, -9999999);//With letters, numbers and special cases :: large number and negative number

        /* Test that the player variables contains their parameters they were created with*/
        assertEquals(p1Name, newTestPlayer1.name);
        assertEquals(0, newTestPlayer1.score);
        assertEquals(0, newTestPlayer1.wins);

        assertEquals(p2Name, newTestPlayer2.name);
        assertEquals(1, newTestPlayer2.score);
        assertEquals(2, newTestPlayer2.wins);

        assertEquals(p3Name, newTestPlayer3.name);
        assertEquals(1000000, newTestPlayer3.score);
        assertEquals(-9999999, newTestPlayer3.wins);

    }
    
    /*
     * This tests if the array list asserts the correct information given parameters of Players
     */
    public void testPlayerArrayList(){ //extending from Lobby.java
        /* Create players */
        Player newTestPlayer1 = new Player("Billy@^?123", 0, -0); //As intended
        Player newTestPlayer2 = new Player("John@^?123", 10, -10); //Not as intended
        /* Create an ArrayList to store them in */
        ArrayList<Player> PlayersInLobbyTest = new ArrayList<>(4);

        PlayersInLobbyTest.add(newTestPlayer1); //index 0
        PlayersInLobbyTest.add(newTestPlayer2); //index 1

        /* Ensure there are correct amount of elements */
        assertEquals(PlayersInLobbyTest.size(), 2);

        Object PIL_obj[] = PlayersInLobbyTest.toArray(); //Convert type to be compare Object, Object

        /* Ensure the arraylist (now an object array) element contains the same info intended */
        assertEquals(PIL_obj[0], newTestPlayer1);
        assertEquals(PIL_obj[1], newTestPlayer2);

    }
    /*
     * Tests the chat functionality
     */
    public void testChat(){
        Lobby lobby1 = new Lobby(1);

        UserEvent U = new UserEvent();
        U.LobbyNum = 1;
        U.Msg = "[Thomas] Text \n"; //expected
        U.MsgSent = true;

        lobby1.Chatting(U);

        assertEquals(U.Msg, lobby1.chatLog.messages);

        U.LobbyNum = 1;
        U.Msg = "[Thomas]\n"; //unexpected (nothing inputed, just enter key)
        U.MsgSent = true;

        lobby1.Chatting(U);

        assertEquals(U.Msg, lobby1.chatLog.messages);
    }
    /*
     * Tests if modifying the scores work
     */
    public void testModScore(){
        Lobby testLobby = new Lobby(1);
        UserEvent U = new UserEvent();

        U.PlayerIdx = 0; //First player
        U.PlayerName = "Billy@^?123";

        testLobby.AddPlayers(U); //This player should start with a score of 0

        /* Create player obj to be compared */
        Player cmpPlayer = new Player("Billy@^?123", 100, 0); //the end goal
        /* Create an ArrayList to store them in */

        U.ScoreRequest = true;
        U.Score = 100;

        /* Modify the score */
        testLobby.modScore(U, 1); //Assume the player is already in lobby
        /* Check if modifications were as intended */
        assertEquals(testLobby.PlayersInLobby.get(0), cmpPlayer);
    }
    /* 
     * Tests if sorting players by score works
     */
    public void testSort(){
        Lobby testLobby = new Lobby(1);
        UserEvent U = new UserEvent();

        U.PlayerIdx = 0; //First player
        U.PlayerName = "Billy";

        testLobby.AddPlayers(U); //This player should start with a score of 0

        U.PlayerIdx = 0; //First player
        U.PlayerName = "John";

        testLobby.AddPlayers(U); //This player should start with a score of 0

        Player cmpPlayer1 = new Player("Billy", 0, 0);
        assertEquals(testLobby.PlayersInLobby.get(0), cmpPlayer1);

        U.ScoreRequest = true;
        U.Score = 100;

        testLobby.modScore(U, 2); //Should modify John's score
        testLobby.sortByScore(); //This will passively call in real application

        Player cmpPlayer2 = new Player("John", 100, 0);
        assertEquals(testLobby.PlayersInLobby.get(0), cmpPlayer2); //John should be first because they have highest score


    }

    public void testSurrenderPlayer(){
        Lobby lobby1 = new Lobby(1);

        int[] PlayerIds = {-1, 1, -1, -1};

        UserEvent userEvent = new UserEvent();
        userEvent.PlayerName = "Bob";
        userEvent.PlayerIdx = 0;

        lobby1.SurrenderPlayer(userEvent);

        assertArrayEquals(PlayerIds, lobby1.PlayerIds);
    }
}
