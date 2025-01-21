// Theodore Truebe 
// Units 05&06 Exam Part 1

import java.util.Arrays;

public class Units_05_06_ExamPart1 {
    public static void swap(int x, int y, int[] whichArray ){
        // Finds out which numbers need to be swapped
        int firstNum = whichArray[x];
        int secondNum = whichArray[y];
        // Swaps the numbers
        for (int i = 0; i < whichArray.length;){
            if (i == x){
                whichArray[i] = secondNum;
            } 
            if (i == y){
                whichArray[i] = firstNum;
            }
            i += 1;
        }
    }
    public static void main(String[] args) {
        // Creates array
        int [] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Initiates swap method
        swap(2, 7, numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
