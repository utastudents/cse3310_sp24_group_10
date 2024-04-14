package uta.cse3310;
import java.util.Timer;
import java.util.TimerTask;  

public class GameTimer
{
   private int seconds = 0;

   private Timer time = new Timer();
   
   private TimerTask task = new TimerTask()
   {
        public void run()
        {
            
            seconds++;

            //test timer
            System.out.println("seconds: " + seconds + System.lineSeparator());

            //cancel when at 30 seconds
            if(seconds >= 30)
            {
                time.cancel();
            }
        }
    };

    public int getSeconds()
    {
        return seconds;
    }

    public void start()
    {
        time.scheduleAtFixedRate(task,1000,1000);
    }

    public void stop()
    {
        time.cancel();
    }

}