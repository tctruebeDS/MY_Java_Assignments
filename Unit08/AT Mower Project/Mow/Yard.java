package Mow;

public class Yard {

    // Public member variables
    public char[][] yardArray;
    public static int rows;
    public static int columns;

    public Yard(int rows, int columns) {

        yardArray = new char[rows][columns];
        this.rows = rows;
        this.columns = columns;

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
    public void mowSpot(int thatRow, int thatColumn){
        yardArray[thatRow][thatColumn] = ' ';
    }

    public void printYard(char[][] g) {
        for (int i = 0; i < rows; i++) {

            for (int y = 0; y < columns; y++) {

                System.out.print(g[i][y]);
                if (y == columns - 1) {
                    System.out.println();

                }
            }
        }
    }

    public int getYardHeight(){
        int yardHeight = columns-2;
        return yardHeight;
    }
    public int getYardWidth(){
        int yardWidth = rows-2;
        return yardWidth;
    }

    public static void main(String[] args) {
        
    }
}