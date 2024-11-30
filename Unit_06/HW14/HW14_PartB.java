package HW14;

/* Theodore Truebe
 * HW 14 Part B
 */
public class HW14_PartB {
    public static void main(String[] args) {
        // create array
        double[] numbers = new double[] { 2.2, 1.0, 3.7, 4.1, 88.0 };
        // declare variables
        int index = 0;
        double total = 0;
        double finalAverage;
        while (index < numbers.length) {
            System.out.println(numbers[index]);
            // add number to total for average later
            total += numbers[index];
            // go to the next number in the array when the loop runs again
            index++;
        }
        // calculate average
        finalAverage = total / index;
        // print average
        System.out.println("Avg = " + finalAverage);
    }
}
