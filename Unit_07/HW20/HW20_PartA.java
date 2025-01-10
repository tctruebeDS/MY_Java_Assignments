package HW20;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class HW20_PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("HW20/customerdata.txt");
        Scanner in = new Scanner(inputFile);
        // change delimiter
        int id = 0;
        in.useDelimiter("[^--√]+");
        double balance = 0;
        boolean running = true;
        // prints first formatted part
        System.out.printf("---------------------------------------%n  ID  |    Name     |     Balance %n---------------------------------------%n");
        // prints everything
        while (running) {
            if(in.hasNextInt()){
                id = in.nextInt();
                System.out.printf("%06d|", id);

            } else if(in.hasNextDouble()){
                balance = in.nextDouble();
                System.out.printf(" $      %.2f%n", balance);
            } else if(in.hasNext()){
                String word = in.next();
                System.out.printf("%12s |",word);
            } else{
                running = false;
            }
        }
        in.close();
    }
}
