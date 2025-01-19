package AdvancedTopic08.AdvTopic08PB;


// Theodore Truebe
// Advanced Topic 8 Part B
// Pardon the mess with importing
// Fixed it, I don't know why the package stuff was broken, but I had %d instead of %f for printing the double 
import AdvancedTopic08.AdvTopic08PB.org.derryfield.math.Geometry;
public class AdvTopic08_PartB {
    public static void main(String[] args) {
        System.out.println("The following double is the volume of a sphere with a radius of 3:");
        System.out.printf("%.2f%n", Geometry.calcVolSphere(3));
        System.out.println("The following double is the surface are of a sphere with a radius of 3:");
        System.out.printf("%.2f%n", Geometry.calcSurfSphere(3));
    }
}
