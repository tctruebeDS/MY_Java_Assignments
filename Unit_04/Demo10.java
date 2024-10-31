package Unit_04;
import java.util.Scanner;
public class Demo10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        @SuppressWarnings("unused")
        int a;
        double x = 3.14;
        a = (int) x;
        String name = "Harry";
        for (int i = 0; i < name.length(); i++) {
            System.out.println(name.charAt(i));
        }
        double value;
        double count = 0;
        double total = 0;
        do {
            System.out.print("Enter how much money you spent or a negative value to exit: ");
            value = in.nextDouble();
            count = count + 1;
            total = total + value;

            // debug print statements.
            System.out.println("  DEBUG: count = " + count);
            System.out.printf("  DEBUG: total = %.2f%n", total);

        } while (value >= 0);
        in.close();
    }
    
}
