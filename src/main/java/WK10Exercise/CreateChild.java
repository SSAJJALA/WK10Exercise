package WK10Exercise;

import java.util.concurrent.TimeUnit;

/**
 * Created by student on 11/3/16.
 */
public class CreateChild implements Runnable{
    Rhome home;

    public CreateChild(Rhome home)
    {
        this.home = home;
    }

    public void run()
    {
        while(true)
        {
            Child child = new Child(home);

            Thread thChild = new Thread(child);
            child.setName("Child "+thChild.getId());
            System.out.println(child.getName() + " created");
            thChild.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*3));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
