// Theodore Truebe
// HW R02 Part B 
// Checks if a string is a palindrome
public class HWR02PartB {
    public static boolean hasMismatch = false;

    public static boolean checkPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[,.?!]+", "");
        int sLength = s.length();
        for (int i = 0; i < sLength - 1; i++) {
            char checkedChar = s.charAt((sLength - i) - 1);
            if (s.charAt(i) != checkedChar) {
                hasMismatch = true;

            }
        }
        if (hasMismatch == true) {
            return false;
        } else {
            return true;
        }

    }

    public static void main(String[] args) {

        System.out.println(checkPalindrome("Race!Car!!!,!"));
        System.out.println(checkPalindrome("none!"));
    }
}
