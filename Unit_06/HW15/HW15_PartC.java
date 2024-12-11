// Theodore Truebe
// HW15 Part C
package HW15;

import java.util.Arrays;
import java.util.Random;

public class HW15_PartC {

    public static int linearSearch(int[] array, int tgtVal) {
        int index = -1;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == tgtVal) {

                index = i;
                break;
            }

        }
        return index;

    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        final int MAX = 10000;

        Random rand = new Random();
        // generate array

        int array[] = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            int r = rand.nextInt(MAX) + 1;
            array[i] = r;
        }
        int tgt = rand.nextInt(MAX) + 1;
        int index = -1;
        linearSearch(array, tgt);

        long stopTime = System.nanoTime();
        if (index < 0) {
            System.out.println("The number was not found.");
        } else {
            System.out.println("Start time: " + startTime);
            System.out.println("Stop time: " + stopTime);
            long eTime = stopTime - startTime;
            System.out.println("Elapsed time: " + eTime);
        }
        // Binary search
        long newStart = System.nanoTime();
        Arrays.sort(array);
        // generate random value to search for

        int binIndex = Arrays.binarySearch(array, tgt);
        long newEnd = System.nanoTime();
        long newETime = newEnd - newStart;
        if (binIndex > 0) {
            System.out.println("The binary search time was " + newETime);
        } else {
            System.out.println("Not found");
        }

    }
}
