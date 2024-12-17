import java.util.Arrays;

public class SwapArray {
    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] values = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(Arrays.toString(values));
        swap(values, 2, 7);
        System.out.println(Arrays.toString(values));
        
        // passed by referance
        int[] original = { 7, 3, 2, 5, 1 };
        System.out.println("original: " + Arrays.toString(original));

        Arrays.sort(original);
        System.out.println("sorted:   " + Arrays.toString(original));
    }
}
