// Theodore Truebe
// HW 19 Part A
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class HW19_PartA {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        File inputFile = new File("temps.txt");
        Scanner in = new Scanner(inputFile);
        // Sets the lowest value to a really large value 
        int lowest = Integer.MAX_VALUE;
        // Puts the text file into an array list
        while (in.hasNext()) {
            int singleTemp = in.nextInt();
            temp.add(singleTemp);
        }
        int index = 0;
        // Identifies the real lowest value
        while (index < temp.size()) {
            if (lowest > temp.get(index)) {
                lowest = temp.get(index);
            }
            index++;
        }
        index = 0;
        while (index < temp.size()) {
            if (temp.get(index) == lowest) {
                System.out.printf("%d <=lowest%n", temp.get(index));
            } else {
                System.out.println(temp.get(index));
            }
            index++;
        }
        in.close();

    }
}