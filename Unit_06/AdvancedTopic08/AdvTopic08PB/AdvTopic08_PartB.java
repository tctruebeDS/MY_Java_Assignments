package AdvancedTopic08.AdvTopic08PB;
// Theodore Truebe
// Advanced Topic 8 Part B
// Pardon the mess with importing
import AdvancedTopic08.AdvTopic08PB.org.derryfield.math.Geometry;
public class AdvTopic08_PartB {
    public static void main(String[] args) {
        System.out.println("The following double is the volume of a sphere with a radius of 3");
        System.out.printf("  %.2d%n", Geometry.calcVolSphere(3));
        System.out.println("The following double is the surface are of a sphere with a radius of 3");
        System.out.printf("  %.2d%n", Geometry.calcSurfSphere(3));
    }
}
