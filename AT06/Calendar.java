
/*
 * Theodore Truebe
 * AT HW06 
 */
import java.util.Scanner;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.Month;

public class Calendar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LocalDate rightNow = LocalDate.now();
        LocalDate today = LocalDate.now();

        // gets the current month
        Month month = today.getMonth();
        // gets the number of days in the month
        int daysInMonth = rightNow.lengthOfMonth();
        // makes the month into a string that I can count the length of so I can count
        // it
        String currentMonth = month.toString();
        int nameLength = currentMonth.length();
        nameLength = 14 - (nameLength / 2);
        // puts in the correct number of spaces and the month and the days of the week
        for (int i = 0; nameLength > i; i++) {
            System.out.print(" ");
        }
        System.out.println(month);
        System.out.println("Mon Tue Wed Thu Fri Sat Sun ");
        int dayOfMonth = rightNow.getDayOfMonth();
        LocalDate firstOfMonth = rightNow.minusDays(dayOfMonth - 1);
        DayOfWeek firstDay = firstOfMonth.getDayOfWeek();
        String skip = "    ";
        int m = 0;
        if (firstDay == DayOfWeek.MONDAY) {
            // don't skip
            m = 0;
        } else if (firstDay == DayOfWeek.TUESDAY) {
            System.out.print(skip);
            m = 1;
        } else if (firstDay == DayOfWeek.WEDNESDAY) {
            for (int y = 0; y < 2; y++) {
                System.out.print(skip);
                m = 2;
            }
        } else if (firstDay == DayOfWeek.THURSDAY) {
            for (int y = 0; y < 3; y++) {
                System.out.print(skip);
                m = 3;
            }
        } else if (firstDay == DayOfWeek.FRIDAY) {
            for (int y = 0; y < 4; y++) {
                System.out.print(skip);
                m = 4;
            }
        } else if (firstDay == DayOfWeek.SATURDAY) {
            for (int y = 0; y < 5; y++) {
                System.out.print(skip);
                m = 5;
            }
        } else if (firstDay == DayOfWeek.SUNDAY) {
            for (int y = 0; y < 6; y++) {
                System.out.print(skip);
                m = 6;
            }
        }
        // outputs the calender numbers and puts an asteriks on the current day of the month
        for (int x = 1; x < daysInMonth + 1; x++) {
            if (x == today.getDayOfMonth()) {
                System.out.print(" " + x + "*");
            } else if (x < 10) {
                System.out.print("  " + x + " ");
            } else {
                System.out.print(" " + x + " ");
            }
            if (m == 6) {
                System.out.println("");
                m = 0;
            } else {
                m += 1;
            }
        }
        in.close();
    }
}
