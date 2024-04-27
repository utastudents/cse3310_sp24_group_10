package uta.cse3310;

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
*/

public class Generator {
  public static char[][] createGrid(ArrayList<String> words, long seed)
  {
    boolean debug = true;
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
    Point head = new Point(0, 0);
    boolean running = true;
    List<Point> taken_index = new ArrayList<>();

    /* Populate words */
    while (running)
    {
      List<Integer> valid = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
      // Chance to create word
      if (rand_num.nextInt(2) == 0)
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
            // Check if current character position occupied 
            if ((taken_index.contains(new Point(runner.x, runner.y))))
            {
              // Check if the word can be an overlap
              if (my_array[runner.x][runner.y] == words.get(word_index).charAt(i))
              {
                overlap ++;
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
                runner.x ++;
                runner.y --;
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
                break;
              case 1:
                runner.y ++;
                break;
              case 2:
                runner.x ++;
                runner.y ++;
                break;
              case 3:
                runner.x ++;
                runner.y --;
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
      System.out.format("Size of taken_index: %d, percentage of word chars: %f, overlap attempts: %d\n", taken_index.size(), 100.0 * taken_index.size() / (size * size), overlap);
    }

    return my_array;
  }


  public static ArrayList<String> getWords(ArrayList<String> words, long seed)
  {
    ArrayList<String> result = new ArrayList<>();
    boolean debug = false;
    final int size = 50;

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
}
