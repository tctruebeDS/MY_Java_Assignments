package HW17;

public class HW17_PartB {
    public static void printArray(int[][] array1, int[][] array2) {
        System.out.println("First array: ");
        for (int row = 0; row < array1.length; row++) {
            for (int col = 0; col < array1[0].length; col++) {
                System.out.print(array1[row][col]);
                // only print a comma if it's not the last column.
                if (col < array1[0].length - 1) {
                    System.out.print(", ");
                }

            }
            System.out.println();
        }
        System.out.println("Second array: ");
        for (int row = 0; row < array2.length; row++) {
            for (int col = 0; col < array2[0].length; col++) {
                System.out.print(array2[row][col]);
                // only print a comma if it's not the last column.
                if (col < array2[0].length - 1) {
                    System.out.print(", ");
                }

            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] array1 = {
                { 8, 6, 7 },
                { 5, 3, 0 },
        };
        int[][] array2 = {
                { 0, 7, 6, 5 },
                { 2, 2, 0, 1 },
                { 8, 4, 5, 7 },

        };
        printArray(array1, array2);
    }
}
