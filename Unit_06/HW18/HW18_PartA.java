package HW18;
// Theodore Truebe
// HW 18 Part A
import java.util.ArrayList;
import java.util.Scanner;

public class HW18_PartA {
    // Hides annoing warning
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        boolean running = true;
        Scanner in = new Scanner(System.in);
        // Gets user input
        while (running) {
            System.out.println("Enter a name or '#' to quit: ");
            //Stops if user inputs #
            if (in.hasNext("#")) {
                in.next();
                running = false;
                break;
            } else {
                // adds name that user inputs
                names.add(in.next());
            }
        }
        // Prints names with line in between
        int i = 0;
        for (String name : names) {

            System.out.println(names.get(i));
            i++;
        }
        in.close();
    }
}
