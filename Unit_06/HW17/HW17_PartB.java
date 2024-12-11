package HW17;

public class HW17_PartB {


    public static void printArray(int[][] array) {

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[0].length; col++) {
                System.out.print(array[row][col]);
                // only print a comma if it's not the last column.
                if (col < array[0].length - 1) {
                    System.out.print(", ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // defines arrays
        int[][] array1 = {
                { 8, 6, 7 },
                { 5, 3, 0 },
        };
        int[][] array2 = {
                { 0, 7, 6, 5 },
                { 2, 2, 0, 1 },
                { 8, 4, 5, 7 },

        };
        // prints first array
        System.out.println("First array: ");
        printArray(array1);
        // prints second array
        System.out.println("Second array: ");
        printArray(array2);
    }
}
