public class Sand {
  public static void main(String[] args) {
    System.out.println("hello world!");
    printGrid(createGrid());
  }

  public static char[][] createGrid()
  {
    char[][] my_array = { {'a','a','c'},
                          {'b','b','c','b'} };
    return my_array;
  }

  public static void printGrid(char[][] my_array)
  {
    System.out.format("Length of array is: %d\n", my_array[1].length);
    for ( int i = 0; i < my_array[0].length; i ++)
    {
      System.out.format("%c ", my_array[0][i]);
    }
    System.out.format("\n");
    for ( int j = 0; j < my_array[1].length; j ++)
    {
      System.out.format("%c ", my_array[1][j]);
    }
    System.out.format("\n");
  }
}
