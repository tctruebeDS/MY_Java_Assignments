public class HWR02PartA {
    public static int n = 0;
    public static String newString = "";
    public static String firstString = "";
    public static boolean hasSet = false;
    
    // Theodore Truebe
    // HW R02 Part A
    // Checks if a string is a palindrome
    public static boolean invertString(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[,.?!]+", "");
        if (hasSet == false) {
            firstString = s;
        }
        s.toLowerCase();
        s.replaceAll(" ", "");

        
        n = s.length() - 1;
        if (n != 1 ){

            newString = newString + s.charAt(n);
            s.substring(0, n);
            invertString(s.substring(0, n));
        }

        if (newString.equals(firstString)) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {

        System.out.println(invertString("A?bba!!!!!!!!"));
        System.out.println(invertString("naadas"));
    }

}