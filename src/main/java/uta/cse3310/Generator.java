package uta.cse3310;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;


/* FOR FUTURE
   - Add a flag for word overlapping to only happen once per for loop
   - Remove the getWords method and roll it into the createGrid
   - Fix syntax having crossed X and Y
 */

public class Generator {
  static public ArrayList<String> words = new ArrayList<>();
  static boolean has_read = false; // Dirty implementation to read from the file only once
  public static char[][] createGrid(long seed)
  {
    boolean debug = false;
    final int size = 25;
    int overlap = 0;

    Random rand_num = new Random(seed);
    char[][] my_array = new char[size][size];

    // Create initial random board
    for ( int x = 0; x < size; x ++)
    {
      for ( int y = 0; y < size; y ++)
      {
        if (debug)
        {
          //my_array[x][y] = (char) (rand_num.nextInt('Z' + 1 - 'A') + 'A');
          my_array[x][y] = '_';
        } else 
        {
          // Upper bound is exclusive, therefore skew 'z' by one
          my_array[x][y] = (char) (rand_num.nextInt('z' + 1 - 'a') + 'a');
        }
      }
    }

    int head_x = 0; 
    int head_y = 0; 

    Point head = new Point(15, 15); // Fix for getting diagnol up generating
    boolean running = true;
    List<Point> taken_index = new ArrayList<>();
    int stats[] = {0, 0, 0, 0};
    int[] overlap_used = new int[] {0, 0, 0, 0};

    /* Populate words */
    while (running)
    {
      List<Integer> valid = new ArrayList<>(Arrays.asList(0, 1, 2, 3));

      // Chance to create word
      if (rand_num.nextInt(1) == 0)
      {
        int word_index = rand_num.nextInt(words.size());
        int word_len = words.get(word_index).length();

        Point runner = new Point(head.x, head.y);

        int valid_size = valid.size();
        // Loop through the four valid directions
        for (int j = 0; j < valid_size; j ++)
        {
          runner = new Point(head.x, head.y);
          // For each direction, check if the word position is valid
          for (int i = 0; i < word_len && valid.contains(j); i ++)
          {
            // Check if current character position occupied 
            if ((taken_index.contains(new Point(runner.x, runner.y))))
            {
              // Check if the word can be an overlap
              if (my_array[runner.x][runner.y] == words.get(word_index).charAt(i))
              {
                overlap_used[j] = overlap_used[j] + 1;
              } else // Invalidate this position
              {
                valid.remove(Integer.valueOf(j));
              }
            }
            // Invalid position
            if (runner.y == -1 || runner.x == -1 || runner.x == size || runner.y == size)
            {
              valid.remove(Integer.valueOf(j));
            }
            switch (j)
            {
              case 0: // Horizontal
                runner.x ++;
                break; 
              case 1: // Vertical
                runner.y ++;
                break;
              case 2: // Diagnal down 
                runner.x ++;
                runner.y ++;
                break;
              case 3: // Diagnal up 
                runner.y --;
                runner.x ++;
                break;
              default:
                break;
            }
            // Special check for diagnal up
            if (runner.x == -1 || runner.y == -1 || runner.x == size || runner.y == size)
            {
              valid.remove(Integer.valueOf(j));
            }
          }
        }

        if (debug)
        {
          System.out.format("head.x: %02d, head.y: %02d, ", head.x, head.y);
          System.out.println("valid array: " + valid);
        }


        /* Create word */
        if (valid.size() != 0)
        {
          int rand_dir = rand_num.nextInt(valid.size()); // Randomly pick an item that is valid
          int direction;
          if (valid.contains(3) && rand_num.nextInt(15) != 0 && valid.contains(1)) // Attempt to encourage diagnal up picks
          {
             direction = 3;
          } else
          {
             direction = valid.get(rand_dir);
          }
          if (overlap_used[direction] > 0)
          {
            overlap ++; // An overlapping word was used
          } 
          // Reset possible overlapping words
          for (int i = 0; i < overlap_used.length; i ++)
          {
            overlap_used[i] = 0;
          }

          Point new_runner = new Point(head.x, head.y);
          runner = new Point(head.x, head.y);

          for (int i = 0; i < word_len; i ++)
          {
            if (debug)
            {
              my_array[runner.y][runner.x] = (char) (i + '0');
              System.out.format("runner.x: %d, runner.y: %d, char: %c, word: %s\n", runner.x, runner.y, words.get(word_index).charAt(i), words.get(word_index));
            System.out.format("word: %s, dir: %s\n", words.get(word_index), direction);
            }
            my_array[runner.y][runner.x] = words.get(word_index).charAt(i); 
            taken_index.add(new Point(runner.x, runner.y)); // Add the positions of word chars to used list
            switch (direction)
            {
              case 0:
                runner.x ++;
                stats[direction] = stats[direction] + 1;
                break;
              case 1:
                runner.y ++;
                stats[direction] = stats[direction] + 1;
                break;
              case 2:
                runner.x ++;
                runner.y ++;
                stats[direction] = stats[direction] + 1;
                break;
              case 3:
                runner.x ++;
                runner.y --;
                stats[direction] = stats[direction] + 1;
                //runner.y --;
                //System.out.format("runner.x: %d, runner.y: %d, char: %c\n", runner.x, runner.y, words.get(word_index).charAt(i));
                break;
            }
          }
        }
      }
      head.x ++;
      // Fix for generating diagnal up
      // Generation starts at point (15, 15) then wraps around to (0, 0)
      if (head.x == 14 && head.y == 14)
      {
        running = false;
      }
      // Check end of array
      if (head.x == size && head.y == size - 1)
      {
        head.x = 0; // Fix for generation diagnal up: starts at (15, 15), then wraps to (0, 0)
        head.y = 0;
      }
      if (head.x == size)
      {
        head.x = 0;
        head.y ++;
      }
    }
    //if (debug)
    {
      float total_words = stats[0] + stats[1] + stats[2] + stats[3]; 
      System.out.format("Size of taken_index: %d, percentage of word chars: %f, overlapping words: %d\n", taken_index.size(), 100.0 * taken_index.size() / (size * size), overlap);
      System.out.format("Horizontal used: %f, vertical used: %f, diagnal down used: %f, diagnal up used: %f\n", (stats[0] / total_words) * 100, (stats[1] / total_words) * 100, (stats[2] / total_words) * 100, (stats[3] / total_words) * 100);
      //System.out.format("Horizontal used: %d, vertical used: %d, diagnal down used: %d, diagnal up used: %d\n", stats[0], stats[1], stats[2], stats[3]);
    }

    return my_array;
  }


  public static ArrayList<String> getWords(long seed)
  {
    ArrayList<String> result = new ArrayList<>();
    boolean debug = false;
    final int size = 25;

    Random rand_num = new Random(seed);
    char[][] my_array = new char[size][size];

    // Create initial random board
    for ( int x = 0; x < size; x ++)
    {
      for ( int y = 0; y < size; y ++)
      {
        if (debug)
        {
          //my_array[x][y] = (char) (rand_num.nextInt('Z' + 1 - 'A') + 'A');
          my_array[x][y] = '_';
        } else 
        {
          // Upper bound is exclusive, therefore skew 'z' by one
          my_array[x][y] = (char) (rand_num.nextInt('z' + 1 - 'a') + 'a');
        }
      }
    }

    int head_x = 0; 
    int head_y = 0; 
    Point head = new Point(0, 0);
    boolean running = true;
    List<Point> taken_index = new ArrayList<>();

    /* Populate words */
    while (running)
    {
      List<Integer> valid = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
      // Chance to create word
      if (rand_num.nextInt(3) == 0)
      {
        int word_index = rand_num.nextInt(words.size());
        int word_len = words.get(word_index).length();





        Point runner = new Point(head.x, head.y);

        int valid_size = valid.size();
        // Loop through the four valid directions
        for (int j = 0; j < valid_size; j ++)
        {
          runner = new Point(head.x, head.y);
          // For each direction, check if the word position is valid
          for (int i = 0; i < word_len; i ++)
          {
            // Current character position occupied 
            if ((taken_index.contains(new Point(runner.x, runner.y))))
            {
              // Check if the word can be an overlap
              if (my_array[runner.x][runner.y] == words.get(word_index).charAt(i))
              {
                //overlap ++;
              } else // Invalidate this position
              {
                valid.remove(Integer.valueOf(j));
              }
            }
            // Invalid position
            if (runner.y == -1 || runner.x == -1 || runner.x == size - 1 || runner.x == size || runner.y == size)
            {
              valid.remove(Integer.valueOf(j));
            }
            switch (j)
            {
              case 0: // Horizontal
                runner.x ++;
                break; 
              case 1: // Vertical
                runner.y ++;
                break;
              case 2: // Diagnal down 
                runner.x ++;
                runner.y ++;
                break;
              case 3: // Diagnal up 
                runner.x ++;
                runner.y --;
                break;
              default:
                break;
            }
            // Special check for diagnal up
            if (runner.x == -1 || runner.y == -1 || runner.x == size - 1 || runner.y == size - 1)
            {
              valid.remove(Integer.valueOf(j));
            }
          }
        }


        if (debug)
        {
          System.out.format("head.x: %02d, head.y: %02d, ", head.x, head.y);
          System.out.println("valid array: " + valid);
        }


        /* Create word */
        if (valid.size() != 0)
        {
          boolean flag = true;
          int rand_dir = rand_num.nextInt(valid.size()); // Randomly pick an item that is valid
          int direction = valid.get(rand_dir);

          Point new_runner = new Point(head.x, head.y);
          runner = new Point(head.x, head.y);

          for (int i = 0; i < word_len; i ++)
          {
            my_array[runner.x][runner.y] = words.get(word_index).charAt(i); 
            taken_index.add(new Point(runner.x, runner.y)); // Add the positions of word chars to used list
            switch (direction)
            {
              case 0:
                runner.x ++;
                if (flag)
                {
                  //System.out.format("%s\n", words.get(word_index));
                  result.add(words.get(word_index));
                  flag = false;
                }
                break;
              case 1:
                runner.y ++;
                if (flag)
                {
                  //System.out.format("%s\n", words.get(word_index));
                  result.add(words.get(word_index));
                  flag = false;
                }
                break;
              case 2:
                runner.x ++;
                if (flag)
                {
                  //System.out.format("%s\n", words.get(word_index));
                  result.add(words.get(word_index));
                  flag = false;
                }
                runner.y ++;
                break;
              case 3:
                runner.x ++;
                runner.y --;
                if (flag)
                {
                  //System.out.format("%s\n", words.get(word_index));
                  result.add(words.get(word_index));
                  flag = false;
                }
                break;
            }
          }
        }
      }
      head.x ++;
      // Check end of array
      if (head.x == size && head.y == size - 1)
      {
        running = false;
      }
      if (head.x == size)
      {
        head.x = 0;
        head.y ++;
      }
    }
    if (debug)
    {
      System.out.format("Size of taken_index: %d, percentage of word chars: %f\n", taken_index.size(), 100.0 * taken_index.size() / (size * size));
    }

    return result;
  }



  public static void initWords()
  {
    if (has_read) // Dirty fix to only read from the file once
    {
      return;
    }
    String file_name = "words_filter.txt";
    System.out.println("attemping to read file");
    try {
      File word_file = new File(file_name);
      Scanner scan = new Scanner(word_file);
      while (scan.hasNextLine())
      {
        words.add(scan.nextLine());
      }
    } catch (FileNotFoundException e)
    { 
      System.out.println("Not able to read '" + file_name + "'");
    } 
    has_read = true;
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

