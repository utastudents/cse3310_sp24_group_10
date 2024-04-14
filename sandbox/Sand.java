import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;

public class Sand {
  public static void main(String[] args) {
    try
    {
      // I/O possibilities:
      // Get desired amount of words (should skew to greater than desired)
      // Generate a random number for each desired
      // Sort random numbers.  Then walk through the word_filter.txt, copying those lines of words to memory
      BufferedReader word_file = new BufferedReader(new FileReader("words_filter.txt"));
      String fline = word_file.readLine();
    }
    catch(Exception e) {
      e.getStackTrace();
    }
    ArrayList<String> word_list = new ArrayList<String>();
   //word_list.add("aaron");
   //word_list.add("abandoned");
   //word_list.add("aberdeen");
   //word_list.add("abilities");
   //word_list.add("ability");
   word_list.add("able");
   //word_list.add("A");
   //word_list.add("aboriginal");
   //word_list.add("abortion");
   //word_list.add("about");
   //word_list.add("above");
   //word_list.add("abraham");
   //word_list.add("abroad");
   //word_list.add("absence");
   //word_list.add("absent");
   //word_list.add("absolute");
   //word_list.add("absolutely");
   //word_list.add("absorption");
   //word_list.add("abstract");
   //word_list.add("abstracts");
   //word_list.add("abuse");
   //word_list.add("academic");
   //word_list.add("academics");
   //word_list.add("academy");
   //word_list.add("accent");
   //word_list.add("accept");
   //word_list.add("acceptable");
   //word_list.add("acceptance");
   //word_list.add("accepted");
   //word_list.add("accepting");
   //word_list.add("accepts");
   //word_list.add("access");
   //word_list.add("accessed");
   //word_list.add("accessibility");
    //printWords(word_list);
    // TODO: word_list should be randomized before being passed to createGrid
    printGrid(createGrid(word_list));
  }

  public static char[][] createGrid(ArrayList<String> words)
  {
    final int size = 15;

    Random rand_num = new Random();
    char[][] my_array = new char[size][size];

    // Create initial random board
    for ( int x = 0; x < size; x ++)
    {
      for ( int y = 0; y < size; y ++)
      {
        // Upper bound is exclusive, therefor skew 'z' by one
        //my_array[x][y] = (char) (rand_num.nextInt('z' + 1 - 'a') + 'a');
        my_array[x][y] = '_';
      }
    }

    // Populate words
    int head_x = 0; 
    int head_y = 0; 
    Point head = new Point(0, 0);
    boolean running = true;
    List<Point> taken_index = new ArrayList<>();

    //while (word_index < words.size())
    //while (!(head.x == size - 1 && head.y == size - 1))
    while (running)
    {
      List<Integer> valid = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
      // Four in five chance to create word
      if (rand_num.nextInt(5) != 0);
      {
        int word_index = rand_num.nextInt(words.size());
        System.out.format("Length is: %02d, word: '%s'\n", words.get(word_index).length(), words.get(word_index));
        int word_len = words.get(word_index).length();


        // Check if horizontal is valid
        for (int i = head.x; (i - head.x) < word_len; i ++)
        {
          // Invalid word position
          if ((taken_index.contains(new Point(i, head.y))) || (i == size))
          {
            valid.remove(Integer.valueOf(0));
          }
        }
        // Check if vertical is valid
        for (int i = head.y; (i - head.y) < word_len; i ++)
        {
          // Invalid word position
          if (taken_index.contains(new Point(head.x, i)) || i == size)
          {
            valid.remove(Integer.valueOf(1));
          }
        }

        Point runner = new Point(head.x, head.y);
        // Check if diagnal down is valid
        for (int i = 0; i < word_len; i ++)
        {
          // Invalid word position
          if (runner.x == size - 1 || runner.y == size - 1 || taken_index.contains(new Point(runner.x, runner.y)))
          {
            valid.remove(Integer.valueOf(2));
          }
          runner.x ++;
          runner.y ++;
        }
        runner = new Point(0, 0);
        // Check if diagnal up is valid
        for (int i = 0; i < word_len; i ++)
        {
          // Invalid word position
          if (runner.y == -1 || runner.x == size - 1 || runner.y == size - 1 || taken_index.contains(new Point(runner.x, runner.y)))
          {
            valid.remove(Integer.valueOf(3));
          }
          runner.x ++;
          runner.y --;
          // Invalid word position
          if (runner.y == -1 || runner.x == size - 1 || runner.y == size - 1 || taken_index.contains(new Point(runner.x, runner.y)))
          {
            valid.remove(Integer.valueOf(3));
          }
        }

        System.out.println("valid array: " + valid);

        int direction = -1;
        if (valid.size() != 0)
        {
          int rand_dir = rand_num.nextInt(valid.size()); // Randomly pick an item that is valid
          direction = valid.get(rand_dir);
        }
        System.out.format("valid direction: %d, valid.size: %d\n", direction, valid.size());


        /* Create word */
        my_array[14][13] = words.get(word_index).charAt(0); 
        Point new_runner = new Point(head.x, head.y);
        runner = new Point(head.x, head.y);
        switch (direction)
        {
          case 0:
            for (int i = 0; i < word_len; i ++)
            {
              System.out.format("runner.x is: %d, runner.y: %d, head.x: %d, head.y: %d\n", new_runner.x, new_runner.y, head.x, head.y);
              my_array[runner.x][runner.y] = words.get(word_index).charAt(i); 
              taken_index.add(new Point(runner.x, runner.y)); // Add the positions of word chars to used list
              runner.x ++;
            }
            break;

          case 1:
            for (int i = 0; i < word_len; i ++)
            {
              my_array[runner.x][runner.y] = words.get(word_index).charAt(i); 
              taken_index.add(new Point(runner.x, runner.y));
              runner.y ++;
            }
            break;
          case 2:
            for (int i = 0; i < word_len; i ++)
            {
              my_array[runner.x][runner.y] = words.get(word_index).charAt(i); 
              taken_index.add(new Point(runner.x, runner.y));
              runner.x ++;
              runner.y ++;
            }
            break;
          case 3:
            for (int i = 0; i < word_len; i ++)
            {
              my_array[runner.x][runner.y] = words.get(word_index).charAt(i); 
              taken_index.add(new Point(runner.x, runner.y));
              runner.x ++;
              runner.y --;
            }
            break;
          default:
            break;
        }

      }
      head.x ++;
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

    return my_array;
  }

  public static void printGrid(char[][] my_array)
  {
    for ( int y = 0; y < my_array.length; y ++)
    {
      for ( int x = 0; x < my_array[y].length; x ++)
      {
        System.out.format("%c ", my_array[x][y], x, y);
      }
      System.out.format("\n");
    }
  }



  public static void printWords(ArrayList<String> words)
  {
    for (var single_word : words)
    {
      System.out.format("%s ", single_word);
    }
  }
}



