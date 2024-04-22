package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uta.cse3310.InitialLobbyTest;
import uta.cse3310.GameTimer;
import uta.cse3310.UserEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class TimerTest extends TestCase{

    public void testTimer(){

        GameTimer timer = new GameTimer();
        
        timer.start();

        //testing timer
        while(timer.getSeconds() <= 30)
        {
            System.out.println("seconds: " + timer.getSeconds() + System.lineSeparator());
        }


    }


}