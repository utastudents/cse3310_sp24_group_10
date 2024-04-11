import java.util.ArrayList;
import java.util.Random;

public class Sand {
  public static void main(String[] args) {
    printGrid(createGrid());
  }

  public static char[][] createGrid()
  {
    final int size = 100;
    
    Random rand_num = new Random();
    //char[][] my_array = { {'a','a','c'},
                          //{'b','b','c','b'} };
    char[][] my_array = new char[size][size];

    for ( int x = 0; x < size; x ++)
    {
      for ( int y = 0; y < size; y ++)
      {
        // 'z' + 1 because upper bound is exclusive
        my_array[x][y] = (char) (rand_num.nextInt('z' + 1 - 'a') + 'a');
      }
    }

    return my_array;
  }

  public static void printGrid(char[][] my_array)
  {
    //System.out.format("Length of array is: %d\n", my_array[0].length);
    //System.out.format("Length of array is: %d\n", my_array[1].length);
    for ( int i = 0; i < my_array[0].length; i ++)
    {
      for ( int j = 0; j < my_array[i].length; j ++)
      {
        System.out.format("%c ", my_array[i][j]);
      }
      System.out.format("\n");
    }
    System.out.format("\n");
  }
}
