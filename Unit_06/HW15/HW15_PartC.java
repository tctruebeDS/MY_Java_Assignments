package HW15;

import java.util.Arrays;
import java.util.Random;

public class HW15_PartC {

    /*
     * public static int linearSearch(int[] array, int tgtVal) {
     * int index = 0;
     * int occurances = 0;
     * while (index < array.length) {
     * 
     * if (array[index] == tgtVal) {
     * occurances += 1;
     * System.out.println("The number " + tgtVal + "was found");
     * 
     * break;
     * }
     * index ++;
     * 
     * }
     * int time = (double)System.currentTimeMillis();
     * System.out.println(time);
     * return time;
     * 
     * }
     */

    public static void main(String[] args) {
        final int MAX = 10;
        Random rand = new Random();
        int array[] = new int[MAX];
        for (int i = 0; i < MAX; i++) {
            int r = rand.nextInt(MAX);
            array[i] = r;
        }
        for (int i = 0; i < MAX; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        // linearSearch(array, 2);
        int index = 0;
        int occurances = 0;
        int tgtVal = 2;
        while (index < array.length) {

            if (array[index] == tgtVal) {
                occurances += 1;
                System.out.println("The number " + tgtVal + " was found");

                break;
            }

            index++;

        }
        if (occurances == 0) {
            System.out.println("The number was not found");
        }
        System.currentTimeMillis();
        Arrays.sort(array);
        Arrays.binarySearch(array, 2);
        System.currentTimeMillis();
    }
}
