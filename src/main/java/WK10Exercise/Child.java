package WK10Exercise;

/**
 * Created by student on 11/3/16.
 */
public class Child implements Runnable{

    String name;

    Rhome home;

    public Child(Rhome home)
    {
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void run()
    {
        goTrickOrTreating();
    }
    private synchronized void goTrickOrTreating()
    {
        home.addChild(this);
    }

}
