import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[5];
        int index = 0;
        // Set max to lowest possible int value
        int mostBiggest = Integer.MIN_VALUE;
        for (int i = 0; i < values.length; i++) {
            System.out.print("Enter a value: ");

            int val = in.nextInt();

            if (index < values.length) {
                values[index] = val;

                index++;
                if (val > mostBiggest) {
                    mostBiggest = val;
                }
            } else {
                // no more space
                System.out.println("The array is full. Exiting loop,");
                break;
            }

        }
        System.out.println("Here are the values entered: ");
        for (int i = 0; i < index; i++) {
            System.out.print(values[i]);
            if (values[i] == mostBiggest) {
                System.out.println(" <= Largest value");
            } else {
                System.out.println();
            }

        }
        in.close();
    }
}
