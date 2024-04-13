package uta.cse3310;
import java.util.Timer;
import java.util.TimerTask;  

public class GameTimer
{
   private int seconds = 0;
   private int minutes = 0;
   private int hours = 0;

   private float totalSeconds = 0f;

   private Timer time = new Timer();
   
   private TimerTask task = new TimerTask()
   {
    
    public void run()
    {
        totalSeconds++;
        seconds++;

        if(seconds > 59)
        {
            minutes++;

            seconds = 0;
        }

        if(minutes > 59)
        {
            hours++;

            minutes = 0;
        }

        if(hours > 23)
        {
            hours = 0;
        }

        //test timer
        System.out.println("hours: " + hours + " minutes: " + minutes + " seconds: " + seconds + "\n");
    }

   };

    public float getSeconds()
    {
        return totalSeconds;
    }

    public float getMinutes()
    {
        return totalSeconds/60;
    }

    public float getHours()
    {
        return totalSeconds/3600;
    }

    public void start()
    {
        time.scheduleAtFixedRate(task,1000,1000);
    }

}