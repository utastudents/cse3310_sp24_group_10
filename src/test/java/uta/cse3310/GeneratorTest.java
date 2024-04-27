package uta.cse3310;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import uta.cse3310.InitialLobbyTest;
import uta.cse3310.Generator;
import uta.cse3310.UserEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class GeneratorTest  extends TestCase{

  public void testGrid(){
    ArrayList<String> words_used = new ArrayList<>(); 

    //printGrid(Generator.createGrid((long) 1234));
    //words_used = Generator.getWords((long) 1234);
    //assertArrayEquals(Generator.createGrid((long) 1234), Generator.createGrid((long) 1234));
    //assertEquals(words_used, Generator.getWords((long) 1234)); // This should not pass!
    //assertEquals(Generator.getWords((long) 1234), Generator.getWords((long) 1234)); 
  }
  public static void printGrid(char[][] my_array)
  {
    final boolean formatted = false;
    for ( int y = 0; y < my_array.length; y ++)
    {
      if (formatted)
      {
        System.out.format("{");
      }
      for ( int x = 0; x < my_array[y].length; x ++)
      {
        if (formatted)
        {
          System.out.format("'%c', ", my_array[y][x], x, y);
        } else
        {
          System.out.format("%c ", my_array[y][x], x, y);
        }
      }
      if (formatted)
      {
        System.out.format("},\n");
      } else
      {
        System.out.format("\n");
      }
    }
  }

}
