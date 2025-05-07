import java.util.Arrays;

import util.ArrayUtil;

public class Search {
    public static void main(String[] args) {
       int[] numbers = ArrayUtil.randomIntArray(20, 100);
       System.out.println("Before: " + Arrays.toString(numbers));
       Arrays.sort(numbers);
       System.out.println("After:  " + Arrays.toString(numbers));
       int index = Arrays.binarySearch(numbers, 5);
       if (index < 0) {
           System.out.println("Value not found!");
       } else {
           System.out.println("Value found at index = " + index);
       }
   }

}
