package Mow;

public class Yard {

    // Public member variables
    public char[][] yardArray;
    public static int rows;
    public static int columns;

    // Private member variables
    private int whichTurn;
    private int delay = 250;
    private int turns;

    public Yard(int rows, int columns) {

        yardArray = new char[rows][columns];
        Yard.rows = rows;
        Yard.columns = columns;
        mower.randomizeMower(this);
        for (int i = 0; i < rows; i++) {

            for (int y = 0; y < columns; y++) {

                if (y == 0 || y == columns - 1 || i == 0 || i == rows - 1) {
                    yardArray[i][y] = 'R';
                } else {
                    yardArray[i][y] = '+';
                }
            }
        }
    }

    public Mower mower = new Mower();
    // Print yard- does as the name suggests- prints yard

    public void printYard(char[][] g) {
        for (int i = 0; i < rows; i++) {

            for (int y = 0; y < columns; y++) {

                if (i == mower.mowerRow && y == mower.mowerColumn) {
                    g[i][y] = mower.mowerVisual;
                }
                System.out.print(g[i][y]);

                if (y == columns - 1) {
                    System.out.println();

                }

            }
        }
    }

    // Delays the animation
    public void delay() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    // Clears the screen
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Updates the image
    private void updateImage() {
        clearScreen();
        mower.findMower();
        printYard(yardArray);
        delay();

    }

    // Cuts in a spiral pattern
    public void cut(boolean spiralCut) {
        if (spiralCut == true) {
            spiralCut();
        } else {
            linearCut();
        }
    }

    // Method for doing a spiral cut pattern
    private void spiralCut() {

        while (unmowedGrass) {

            if (mower.lookForward(yardArray) == '+') {
                mower.moveForward(yardArray);
                updateImage();
                turns = 0;
            } else {

                unmowedGrass();
                swappableTurn(whichTurn);
                updateImage();
                if (turns == 2) {
                    whichTurnBinary();
                }
                turns++;

            }
        }
    }

    // Method for doing a linear cut pattern
    private void linearCut() {
        while (mower.lookForward(yardArray) != '+') {
            mower.turnRight();
            updateImage();
        }
        while (unmowedGrass) {
            if (mower.lookForward(yardArray) == '+') {
                mower.moveForward(yardArray);
                updateImage();
            } else {
                unmowedGrass();
                stripeTurn();
            }
        }
    }

    // Stripe turn- method for turn of linear cut pattern
    private void stripeTurn() {

        swappableTurn(whichTurn);
        updateImage();
        if (mower.lookForward(yardArray) == 'R') {
            whichTurnBinary();
            swappableTurn(whichTurn);
            updateImage();
            swappableTurn(whichTurn);
            updateImage();
        }

        mower.moveForward(yardArray);
        updateImage();
        swappableTurn(whichTurn);
        updateImage();
        whichTurnBinary();
    }

    // SWAPPABLE TURN- method for changing turn directions
    private void swappableTurn(int y) {
        if (y == 0) {
            mower.turnRight();
        } else {
            mower.turnLeft();
        }
    }

    private void whichTurnBinary() {
        if (whichTurn == 0) {
            whichTurn = 1;
        } else {
            whichTurn = 0;
        }
    }

    private boolean unmowedGrass = true;

    private void unmowedGrass() {
        unmowedGrass = false;
        for (int i = 1; i < rows - 1; i++) {

            for (int y = 1; y < columns - 1; y++) {

                if (yardArray[i][y] == '+') {
                    unmowedGrass = true;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}