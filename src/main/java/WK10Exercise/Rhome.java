package WK10Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by student on 11/3/16.
 */
public class Rhome {
    int maxChildren;
    List<Child> listOfChildren;

    public Rhome() {
        maxChildren = 10;
        listOfChildren = new ArrayList<Child>();
    }

    public void distributeCandy() {

        Child child;

        synchronized (listOfChildren) {

            if (listOfChildren.size() == 0) {
                try {
                    System.out.println("Riley watches TV");
                    listOfChildren.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("Riley answers the door");
            child = listOfChildren.get(0);
            listOfChildren.remove(0);
        }

        long duration=0;
        try
        {

            duration = (long)(Math.random()*3);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley gives candy to " + child.getName());


    }

    public void addChild(Child child) {

        System.out.println(child.getName() + " started");

        if (listOfChildren.size() == maxChildren) {
            System.out.println(child.getName() + " left the house");
            return;
        }

        synchronized (listOfChildren) {
            listOfChildren.add(child);
            System.out.println(child.getName() + " rings door bell");
            if (listOfChildren.size() == 1) {
                listOfChildren.notify();
            }

        }
    }

}
