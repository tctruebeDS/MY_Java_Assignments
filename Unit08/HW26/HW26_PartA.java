package HW26;

// Theodore Truebe 
// HW26_PartA

/*
 * 1. A java provided constant static value that is often used in mathematical and/or scientific calculations is Math.PI 
 * 2. A Java-provided static method that is often used in mathematical and/or scientific calculations is Math.pow()
 */ 
public class HW26_PartA {
    public static void main(String[] args) {
        
        double diameter = 4;
        double circumferance = Math.PI*diameter;
        System.out.println("The circumferance of a circle with a diameter of 4 is" + circumferance);
        System.out.println(Math.pow(13, 13));
    }
}
