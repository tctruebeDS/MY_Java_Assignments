
// Theodore Truebe NO3
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SerializationWrite {

    public static void main(String[] args) {
        // display the data, then record it to the file
        Scanner in = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        while (true) {
            System.out.println("Enter (e)mployee or (q)uit: ");
            String token = in.nextLine();
            if (token.toLowerCase().equals("q")) {
                System.out.println("Done!!!");
                break;
            } else {
                // create new employee
                System.out.print("Enter the last name: ");
                String last = in.nextLine();
                System.out.print("Enter the first name: ");
                String first = in.nextLine();
                System.out.print("Enter the salary: ");
                double salary = 0;
                try {
                    token = in.nextLine();
                    salary = Double.parseDouble(token);
                } catch (InputMismatchException e) {
                    System.err.println(" Error parsin' salary");
                    System.err.println(" Usin' $0 as default salary");
                }
                System.out.println();
                Employee.lastIDUsed++;
                Employee e = new Employee(last, first, Employee.lastIDUsed, salary);
                employees.add(e);
            }
        }
        // display the data

        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).getFirstName());
        }
        // record to file.
        String filepath = "data.bin";
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filepath);
                DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            // save the last ID used info.
            dataOutputStream.writeInt(Employee.lastIDUsed);
            for (Employee e : employees) {
                e.writeToStream(dataOutputStream);
            }

            // we're done. the streams should automatically be closed as we exit the try
            // with resources clause.
            System.out.println("Data saved to \"" + filepath + "\"");
        } catch (IOException e) {
            System.err.println("Error writing to output file.");
            System.err.println(e.getMessage());
        }

    }
}
