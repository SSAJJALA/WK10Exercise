package WK10Exercise;

/**
 * Created by student on 11/3/16.
 */
public class TrickOrTreat {

    public static void main(String a[]) {
        Rhome home = new Rhome();
        Riley riley = new Riley(home);
        CreateChild createChild = new CreateChild(home);

        Thread thRiley = new Thread(riley);
        Thread thChild = new Thread(createChild);

        thChild.start();
        thRiley.start();
    }



}
