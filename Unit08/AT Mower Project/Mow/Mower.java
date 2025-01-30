package Mow;

public class Mower {
    // Private member variables- represent where the mower is

    private int row;
    private int column;

    public int direction = 3;
    public char mowerVisual;
    public char mowerLeft = '<';
    public char mowerRight = '>';
    public char mowerDown = 'v';
    public char mowerUp = '^';
    public int mowerRow = 5;
    public int mowerColumn = 5;
    public char inFront;
    public int lookRow;
    public int lookColumn;

    public Mower() {
        findMower();
    }

    public Mower(int mowerRow, int mowerColumn, int direction) {
        findMower();
    }

    public void findMower() {
        getDirection();
        getRow(mowerRow);
        getColumn(mowerColumn);
    }

    public int getRow(int mowerRow) {
        return mowerRow;
    }

    public int getColumn(int mowerColumn) {
        return mowerColumn;
    }

    public void getDirection() {
        switch (direction) {
            case 0:
                faceUp();
                break;
            case 1:
                faceRight();
                break;
            case 2:
                faceDown();
                break;
            case 3:
                faceLeft();
                break;
        }
    }

    public char lookForward(char array[][]) {
        lookRow = mowerRow;
        lookColumn = mowerColumn;
        switch (direction) {
            case 0:
                faceUp();
                lookRow -= 1;
                lookColumn = mowerColumn;
                break;
            case 1:
                faceRight();
                lookColumn += 1;
                lookRow = mowerRow;
                break;
            case 2:
                faceDown();
                lookRow += 1;
                lookColumn = mowerColumn;
                break;
            case 3:
                faceLeft();
                lookColumn -= 1;
                lookRow = mowerRow;
                break;
        }
        if (array[lookRow][lookColumn] == 'R') {
            inFront = 'R';
        } else if (array[lookRow][lookColumn] == ' ') {
            inFront = ' ';
        } else if (array[lookRow][lookColumn] == '+') {
            inFront = '+';
        }
        return inFront;
    }

    public void moveForward(char array[][]) {
        array[mowerRow][mowerColumn] = ' ';
        switch (direction) {
            case 0:
                faceUp();
                mowerRow -= 1;
                break;
            case 1:
                faceRight();
                mowerColumn += 1;
                break;
            case 2:
                faceDown();
                mowerRow += 1;
                break;
            case 3:
                faceLeft();
                mowerColumn -= 1;
                break;
        }
    }

    // Methods for setting the visual for the mower
    public void faceUp() {
        direction = 0;
        mowerVisual = '^';
    }

    public void faceRight() {
        direction = 1;
        mowerVisual = '>';
    }

    public void faceDown() {
        direction = 2;
        mowerVisual = 'v';
    }

    public void faceLeft() {
        direction = 3;
        mowerVisual = '<';
    }

    // Methods for turning the mower
    public void turnLeft() {
        if (direction == 0) {
            direction = 3;
        } else {
            direction += 1;
        }
        getDirection();
    }

    public void turnRight() {
        if (direction == 3) {
            direction = 0;
        } else {
            direction += 1;
        }

        getDirection();
    }





    public static void main(String[] args) {

    }
}