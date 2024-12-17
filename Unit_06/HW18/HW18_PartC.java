package HW18;

import java.util.ArrayList;
import java.util.Scanner;
// Theodore Truebe
// HW18 Part C
public class HW18_PartC {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> temps = new ArrayList<Integer>();
        boolean running = true;
        while (running) {
            System.out.println("Enter a temp or 'q' to quit: ");
            // Stops if user inputs q
            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();
                running = false;
                break;
            } else {
                // adds temps that user inputs
                temps.add(in.nextInt());
            }
        }
        // finds lowest value
        int i = 0;
        int min = temps.get(0);
        for (int temp : temps) {

            int x = temps.get(i);
            if (min > x) {
                min = x;
            }
            i++;
        }
        i = 0;
        // Prints temps with line in between and with <= lowest at previosly found lowest
        for (int temp : temps) {

            int x = temps.get(i);
            if (min == x) {
                System.out.printf("%d<= lowest %n", x);
            } else {
                System.out.printf("%d%n", x);
            }
            i++;
        }
        
        in.close();
    }
}
