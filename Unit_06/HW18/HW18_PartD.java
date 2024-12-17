package HW18;
// Theodore Truebe HW 18 Part D
import java.util.ArrayList;
import java.util.Scanner;

public class HW18_PartD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> values = new ArrayList<Integer>();
        boolean running = true;
        while (running) {
            Integer inputNr;
            System.out.println("Enter a value or 'q' to quit: ");
            // Stops if user inputs q
            if (in.hasNext("q") || in.hasNext("Q")) {
                in.next();
                running = false;
                break;
            } else {
                // adds values that user inputs
                inputNr = in.nextInt();
                values.add(inputNr);
            }
        }
        System.out.println("Before: " + values.toString());
        int i = 0;
        while (i< values.size()){
            int v = values.get(i);
            if (v % 2 == 1){
                values.remove(i);
            } else{
                i++;
            }
        }
        System.out.println("After: " + values.toString());

    }
}
