import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        // Parse input arguments for port
        int port = 8675;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);

            } catch (NumberFormatException e) {
                System.err.println("Couldn't understand port. Use default instead.");
            }
            System.out.printf("port: %d%n", port);
        }
        // try to parse the argument to get the port number.
        int portNumber = 0;
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the port number!");
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        try (
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            System.out.println("Connection made with " + clientSocket.getInetAddress().getHostAddress());
            String msg = "Message received:";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recieved " + inputLine);
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
        System.out.println("Goodbye!");

    }
}
