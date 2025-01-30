package Mow;

import Mow.Mower;

public class Yard {

    // Public member variables
    public char[][] yardArray;
    public static int rows;
    public static int columns;
    public int recentTurns;

    public Yard(int rows, int columns) {

        yardArray = new char[rows][columns];
        Yard.rows = rows;
        Yard.columns = columns;

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

    public void mowerAtSpot() {

        yardArray[mower.mowerRow][mower.mowerColumn] = mower.mowerVisual;

    }

    public Mower mower = new Mower();

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

    boolean running = true;
    boolean turning;
    boolean goingForth;
    public int delay = 500;

    public void delay() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            System.err.println("InterruptedException received!");
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    boolean goingInLine = true;

    public void goInLine() {
        goingInLine = true;
        while (goingInLine) {
            if (mower.lookForward(yardArray) == '+') {
                clearScreen();
                mower.moveForward(yardArray);
                mower.findMower();
                printYard(yardArray);
                delay();
            } else {
                turning = true;
                turning();
            }
        }
    }

    public void turning() {
        while (turning) {

            mower.findMower();

            if (mower.lookForward(yardArray) == '+') {
                recentTurns = 0;
                goInLine();
                

            } else {
                clearScreen();
                mower.turnRight();
                mower.findMower();
                printYard(yardArray);
                delay();
                recentTurns++;
                goingInLine = false;
                if (recentTurns == 4) {
                    turning = false;
                    running = false;
                    break;
                }
            }
        }
    }

    public void mowerGoSpiral(char array[][]) {
        while (running) {
            goInLine();

        }
    }

    public int getYardHeight() {
        int yardHeight = columns - 2;
        return yardHeight;
    }

    public int getYardWidth() {
        int yardWidth = rows - 2;
        return yardWidth;
    }

    public static void main(String[] args) {

    }
}