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
                    System.out.println("Riley goes back to watching TV");
                    listOfChildren.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //System.out.println("Riley finds a child at the door");
            }
            System.out.println("Riley finds a child at the door");
            child = listOfChildren.get(0);
            listOfChildren.remove(0);
        }

        long duration=0;
        try
        {
            System.out.println("Riley distributing the candy for child " + "'" + child.getName() + "'" );
            duration = (long)(Math.random()*3);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Candy given to child " + "'" + child.getName() + "'" );


    }

    public void addChild(Child child) {

        System.out.println("Child " + "'" + child.getName() + "'" + " started");

        if (listOfChildren.size() == maxChildren) {
            System.out.println("Child " + "'" + child.getName() + "'" + " left the house");
            return;
        }

        synchronized (listOfChildren) {
            listOfChildren.add(child);
            System.out.println("Child " + "'" + child.getName() + "'" + " rings the bell");
            if (listOfChildren.size() == 1) {
                listOfChildren.notify();
            }

        }
    }

}
