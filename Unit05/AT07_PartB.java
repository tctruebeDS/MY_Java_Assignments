package Unit05;

import java.util.Scanner;
/*Theodore Truebe
 * AT07 Part B
 */

/*Get x coordinate value
*Get y coordinate value
*Get r (radius) value (polar coordinate)
*Get angle value (polar coordinate)
*Translate (dx,dy) - translate the point dx and dy
*Distance to (point) - returns the distance to another point; takes another point as an argument.
 */
public class AT07_PartB {
    private static double valueX;
    private static double valueY;
    private static double moveX;
    private static double moveY;
    private static double newX;
    private static double newY;

    // constructor
    AT07_PartB() {
        valueX = 0;
        valueY = 0;
    }

    public static void Coordinate() {
        System.out.printf("Your point is at (%.2f,%.2f)%n", valueX, valueY);
    }

    public static double getAngle() {
        double theta = Math.atan(valueY / valueX);
        // calculates theta
        theta = Math.toDegrees(theta);
        return theta;

    }

    public static double getRad() {
        // calculates the radius
        double rad = Math.sqrt((valueX * valueX) + (valueY * valueY));
        return rad;
    }

    public static double translateX() {
        // makes something for translating the point by an x value
        valueX = valueX + moveX;
        double rad = Math.sqrt((valueX * valueX) + (valueY * valueY));
        return rad;
    }

    public static double translateY() {
        // makes something for translating the point by a Y value
        valueY = valueY + moveY;
        double rad = Math.sqrt((valueX * valueX) + (valueY * valueY));
        return rad;
    }

    public static double distanceTo() {
        // finds the distance between the 2 points
        double totalDistance = Math.sqrt(((newX - valueX) * (newX - valueX)) + ((newY - valueY) * (newY - valueY)));
        return totalDistance;
    }

    public static void thetaRad() {
        // outputs theta and the radius
        System.out.printf("Theta = %.2f%n", getAngle());
        System.out.printf("Radius = %.2f%n", getRad());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("The current coordinate is (%.1f,%.1f)%n", AT07_PartB.valueX, AT07_PartB.valueY);
        boolean running = true;
        System.out.print("Enter an X coordinate: ");
        valueX = in.nextDouble();
        System.out.print("Enter a Y coordinate: ");
        valueY = in.nextDouble();
        Coordinate();
        // outputs theta and the radius
        thetaRad();
        // makes a loop so the user can do different things without having to restart
        // the program
        while (running) {

            System.out.print(
                    "Enter X to translate the point by an X value, enter Y to translate the point by a Y value, enter N to add another point, or enter Q to quit: ");
            String input = in.nextLine();
            input = input.toLowerCase();
            // finds out what the user wants to do
            if (input.equals("x")) {
                System.out.print("Enter the value that you would like to translate the X by: ");
                moveX = in.nextDouble();
                translateX();
                // outputs theta and the radius
                thetaRad();
            } else if (input.equals("y")) {
                System.out.print("Enter the value that you would like to translate the Y by: ");
                moveY = in.nextDouble();
                translateY();
                thetaRad();
                // outputs theta and the radius
            } else if (input.equals("n")) {
                System.out.print("Enter the X coordinate for the new point: ");
                newX = in.nextDouble();
                System.out.print("Enter the Y coordinate for the new point: ");
                newY = in.nextDouble();
                System.out.printf("The distance between the two points = %.2f%n", distanceTo());
            } else if (input.equals("q")) {
                break;
            } else if (input.equals("")) {
                // does nothing if the input is blank
            } else {
                //
                System.err.println("Error.");
            }
        }

        in.close();
    }

}
