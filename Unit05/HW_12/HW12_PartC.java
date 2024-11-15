package Unit05.HW_12;

import java.util.Scanner;

// Theodore Truebe
// HW12 Part C
public class HW12_PartC {
    static int vowels;
    static String phrase;
    static String inputChar;
    static boolean isVowel;
//Method to check if a character is a vowel
    public static void isVowel() {
        if (inputChar.equals("a")) {
            isVowel = true;
        } else if (inputChar.equals("e")) {
            isVowel = true;
        } else if (inputChar.equals("i")) {
            isVowel = true;
        } else if (inputChar.equals("o")) {
            isVowel = true;
        } else if (inputChar.equals("u")) {
            isVowel = true;
        }
    }
//loops a program that sets the input character for isVowel() and counts how many times isVowel returns true
    public static int countVowels(String phrase) {
        for (int i = 0; i < phrase.length(); i++ ){
            inputChar = phrase.substring(i, i+1);
            isVowel();
            if (isVowel == true){
                vowels += 1;
                isVowel = false;
            }
            
        }
        return vowels;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // gets user input
        System.out.print("Enter a phrase with vowels: ");
        phrase = in.nextLine();
        countVowels(phrase);
        // outputs number of vowels
        System.out.println(vowels);
        in.close();
    }

}
