// Theodore Truebe NO3
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SerializationRead {

    public static void main(String[] args) {
        // display the data, then record it to the file
        Scanner in = new Scanner(System.in);
        // display the data
        // read from file
        String filepath = "data.bin";
        System.out.println("Enter a filepath or nothing to use data.bin: ");
        String token = in.nextLine();
        if (token.isBlank() == false) {
            filepath = token;
        }        
        try (
                FileInputStream fileInputStream = new FileInputStream(filepath);
                DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            // Read the lastIDUsed value first
            Employee.lastIDUsed = dataInputStream.readInt();
            System.out.println("Last ID Used: " + Employee.lastIDUsed);
            while (dataInputStream.available() > 0) {
                Employee em = new Employee();
                em.readFromStream(dataInputStream);
                System.out.printf("ID: %d%n Last Name: %s%n First Name: %s%n Salary: %02f%n", em.getID(),
                        em.getLastName(), em.getFirstName(), em.getSalary());
            }
        } catch (IOException e) {
            System.err.println("Error reading.");
            System.err.println(e.getMessage());
        }

    }
}
