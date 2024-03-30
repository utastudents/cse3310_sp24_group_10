// Copyright 2023 Ethan W. Grandin <https://github.com/Echo82>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or 
// (at your option) any later version, see <https://www.gnu.org/licenses/>.
package library;
import java.time.Duration;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Models a video
 * 
 * @version             1.0
 * @since               1.0
 */
public class Video extends Publication 
{
  private Duration runtime;

  /**
   * Creates a video instance
   * 
   * @param title       The video's name   
   * @param author      The author of the video  
   * @param copyright   The year as a number of copyright 
   * @param runtime     The runtime as a number in minutes 
   * @since             1.0
   */
  public Video(String title, String author, int copyright, int runtime)
  {
    super(title, author, copyright);
    if (runtime <= 0)
    {
      throw new InvalidRuntimeException(title, runtime);
    }
    this.runtime = Duration.ofMinutes(runtime);
  }
  public Video(BufferedReader br) throws IOException
  {
    super(br);
    long runtime_in = (Long.parseLong(br.readLine()));
    if (runtime_in <= 0)
    {
      throw new InvalidRuntimeException(title, (int) runtime_in);
    }
    this.runtime = Duration.ofMinutes(runtime_in); 
    System.out.println(String.format("past video video reconstruct function\n"));
  }
  public void save(BufferedWriter bw) throws IOException
  {
    super.save(bw);
    System.out.println(String.format("reached video save function\n"));
    bw.write(String.format("%d\n", runtime.toMinutes()));
    System.out.println(String.format("past video save function\n"));
  }

  /**
   * Returns a formatted string describing the title, author, copyright date, runtime, and loaned to information if loanedTo is not null
   * 
   * @return            String of title, copyright, runtime, and loanedTo information 
   * @since             1.0
   */
  @Override
    public String toString()
    {
      return "Video \"" + title + "\" by " + author + ", copyright " + copyright
        + ", runtime " + runtime.toMinutes() + " minutes" + ((loanedTo != null) ? "\n  : loaned to " + loanedTo + " until " + dueDate
            : "");
    }

  /**
   * Returns a exception describing the relevant error
   * 
   * @since               1.0
   */
  public class InvalidRuntimeException extends ArithmeticException
  {
    /**
     * Returns an exception
     * 
     * @since               1.0
     */
    public InvalidRuntimeException()
    {
      super();
    }
    /**
     * Returns a exception describing the error
     * 
     * @param message       The message to use in the exception
     * @since               1.0
     */
    public InvalidRuntimeException(String message)
    {
      super(message);
    }
    /**
     * Returns a exception describing the runtime error
     * 
     * @param title         The title of the work
     * @param runtime       The runtime of the work
     * @since               1.0
     */
    public InvalidRuntimeException(String title, int runtime)
    {
      super(String.format("Invalid runtime '%d' under title '%s'", runtime, title));
    }
  }
}
