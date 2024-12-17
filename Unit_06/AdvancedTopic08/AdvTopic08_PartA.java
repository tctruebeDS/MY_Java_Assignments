package AdvancedTopic08;
import java.time.LocalDate;
import java.time.LocalTime;
// Theodore Truebe
// Advanced Topic 08 Part A HW 

public class AdvTopic08_PartA {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        System.out.println("Today's date is "+ currentDate);
        LocalTime currentTime = LocalTime.now();
        System.out.println("The time is "+ currentTime);
    }
}
