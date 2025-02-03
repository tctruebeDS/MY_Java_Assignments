import Mow.Yard;
import java.util.Scanner;

// Theodore Truebe 
// Mower Project
public class Mower_Project {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static boolean whichCut;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        // Gets user input for rows
        while (running) {
            System.out.print("Enter the height of the yard: ");
            if (in.hasNextInt()) {
                Yard.rows = in.nextInt();
                break;
            } else {
                System.err.println("Error.");
                in.next();
            }
        }
        // Gets user input for columns
        while (running) {
            System.out.print("Enter the width of the yard: ");
            //
            if (in.hasNextInt()) {
                Yard.columns = in.nextInt();
                break;
            } else {
                System.err.print("Error. ");
                in.next();
            }
        }
        Yard yard = new Yard(Yard.rows + 2, Yard.columns + 2);

        // Gets user input to find out which kind of cut pattern is going to be
        // attempted
        while (running) {
            System.out.print("Enter 'S' to cut the lawn in a spiral or 'L' to cut the lawn in a line-by-line pattern: ");
            if (in.hasNext("S") || in.hasNext("s")) {
                whichCut = true;
                break;
            } else if (in.hasNext("L") || in.hasNext("l")) {
                whichCut = false;
                break;
            } else {
                in.next();
                System.err.print("Error. ");
            }
        }

        clearScreen();

        yard.cut(whichCut);

        in.close();
    }
}
