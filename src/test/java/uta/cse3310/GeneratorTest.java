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
    ArrayList<String> word_list = new ArrayList<String>();
    word_list.add("aaron");
    word_list.add("abandoned");
    word_list.add("aberdeen");
    word_list.add("abilities");
    word_list.add("ability");
    word_list.add("able");
    word_list.add("aboriginal");
    word_list.add("abortion");
    word_list.add("about");
    word_list.add("above");
    word_list.add("abraham");
    word_list.add("abroad");
    word_list.add("absence");
    word_list.add("absent");
    word_list.add("absolute");
    word_list.add("absolutely");
    word_list.add("absorption");
    word_list.add("abstract");
    word_list.add("abstracts");
    word_list.add("abuse");
    word_list.add("academic");
    word_list.add("academics");
    word_list.add("academy");
    word_list.add("accent");
    word_list.add("accept");
    word_list.add("acceptable");
    word_list.add("acceptance");
    word_list.add("accepted");
    word_list.add("accepting");
    word_list.add("accepts");
    word_list.add("access");
    word_list.add("accessed");
    word_list.add("accessibility");

    //printGrid(Generator.createGrid(word_list, (long) 1234));
    words_used = Generator.getWords(word_list, (long) 1234);
    assertArrayEquals(Generator.createGrid(word_list, (long) 1234), Generator.createGrid(word_list, (long) 1234));
    assertEquals(words_used, Generator.getWords(word_list, (long) 1234));
    printGrid(Generator.createGrid(word_list, (long) 1234));
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
