package Mow;

public class Mower {
    // Private member variables- represent where the mower is
    public int direction;
    public char mowerVisual;
    public char mowerLeft = '<';
    public char mowerRight = '>';
    public char mowerDown = 'v';
    public char mowerUp = '^';
    public int mowerRow;
    public int mowerColumn;
    public char inFront;
    public int lookRow;
    public int lookColumn;

    public Mower() {
        findMower();
    }

    // Mower overridden constructor
    public Mower(int row, int column, int direction) {
        mowerRow = row;
        mowerColumn = column;
        this.direction = direction;
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

    // Retrieves the direction
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

    // Looks at the direction the mower is facing and advances the mower in the
    // proper direction
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
        inFront = array[lookRow][lookColumn];
        return inFront;
    }

    // Move forward method looks the direction the mower is facing and advances the
    // mower in the proper direction
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
            direction -= 1;
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

    // Generates randomized mower
    public void randomizeMower(Yard yard) {
        int corner = (int) (Math.random() * 4);
        switch (corner) {
            case 0:
                this.mowerRow = 1;
                this.mowerColumn = 1;
                break;
            case 1:
                this.mowerRow = 1;
                this.mowerColumn = Yard.columns - 2;
            case 2:
                this.mowerRow = Yard.rows - 2;
                this.mowerColumn = 1;
                break;
            case 3:
                this.mowerRow = Yard.rows - 2;
                this.mowerColumn = Yard.columns - 2;
                break;
        }
        this.direction = (int) (Math.random() * 3);

    }
    // Cryptic numbers
    // 0 12 3

    // 0 12 3
    // 0 12 3

    // 0 12 3

    public static void main(String[] args) {

    }
}