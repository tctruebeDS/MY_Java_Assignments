package AdvancedTopic08.AdvTopic08PB.org.derryfield.math;
// Theodore Truebe 
// Advanced Topic 8 Part B Package
// Pardon the mess with importing
public class Geometry {
    // Does the calculations for volume of the sphere
    public static double calcVolSphere(double r){
        double volSphere = (4/3) *Math.PI*(r*r*r);
        return volSphere;
    }
// Does the calculations for surface are of the sphere
    public static double calcSurfSphere(double r){
        double surfSphere = 4*Math.PI*(r*r);
        return surfSphere;
    }

}
