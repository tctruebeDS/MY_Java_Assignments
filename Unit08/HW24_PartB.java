import java.util.Scanner;

// Theodore Truebe HW24 Part B
public class HW24_PartB {
    // Constructer- can tell because it does not have a return type
    // Initialize count to 0

    public HW24_PartB() {
        this.register = MIN_COUNT;
    }

    // Overloaded constructor that takes initial value of count;
    public HW24_PartB(int register) {
        this.register = register;
    }

    // Public interface
    public int look() {
        return register;
    }

    // Click- Adds 1 to count
    public void click() {
        if (register == MAX_COUNT) {
            reset();
        } else {
            register++;
        }

    }

    // Resets counter
    public void reset() {
        register = MIN_COUNT;
    }

    // Private member variables used to model the state of the object
    private int register;
    private final int MAX_COUNT = 9999;
    private final int MIN_COUNT = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean running = true;
        String input = "";
        // Creats instance of counter for cake
        HW24_PartB cake = new HW24_PartB();

        // Creates instance of counter for pie
        HW24_PartB pie = new HW24_PartB();

        while (running == true) {
            // Prints cake and pie values and gets user input
            pie.look();
            cake.look();
            System.out.printf("Pie = %04d %nCake = %04d %n", pie.register, cake.register);
            System.out.print("Enter 'c' for cake, 'p' for pie, or 'q' to quit: ");
            input = in.next();
            if (input.equalsIgnoreCase("c")) {
                // Adds 1 to cake
                cake.click();

            } else if (input.equalsIgnoreCase("p")) {
                // Adds 1 to pie
                pie.click();

            } else if (input.equalsIgnoreCase("q")) {
                // Outputs final values for cake and pie
                pie.look();
                cake.look();
                System.out.printf("%n%n%nFINAL VALUES:%n--------------%n Pie | %04d %nCake | %04d %n%n%n", pie.register,
                        cake.register);
                break;
            } else {
                // Returns error for invalid input

                System.err.println("Error.");
            }

        }

        in.close();

    }
}
