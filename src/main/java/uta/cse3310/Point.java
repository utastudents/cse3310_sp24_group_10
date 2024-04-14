public class Point implements Comparable<Point>{
//public class Point {
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
        
    @Override
    public int compareTo(Point point)
    {
      System.out.format("Called here\n\n\n");
      if (point.x < x)
      {
        return -1;
      } else if (point.x > x)
      {
        return 1;
      } else if (point.y < y)
      {
        return -1;
      } else if (point.y > y)
      {
        return 1;
      }
      return 0;
    }

    @Override
    public boolean equals(Object o)
    {
      Point point = (Point) o;
      if (point.x == x && point.y == y)
      {
        return true;
      }
      return false;
    } 

    int x;
    int y;
}
