package WK10Exercise;

/**
 * Created by student on 11/3/16.
 */
public class Riley implements Runnable{
    Rhome home;

    public Riley(Rhome home)
    {
        this.home = home;
    }
    public void run()
    {
        System.out.println("Riley started");
        while(true)
        {
            home.distributeCandy();
        }
    }
}
