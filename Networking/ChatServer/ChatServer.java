
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer {
    static ArrayList<clientHandler> clientList = new ArrayList<>();

    // GetPortNumber method goes here, has
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // For each client handler in the array list, the server sends a copy of the
        // message to the client device.
        // Whenever a client device sends a message to the server, the server uses this
        // method to resend the message to all currently connected devices.

        // try to parse the argument to get the port number.
        int portNumber = 8675;
        try {
            portNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Unable to parse the port number!");
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        try (ServerSocket serverSocket = new ServerSocket(portNumber);) {
            System.out.println("Listening on port " + portNumber);
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept(); // Accept incoming client connection
                    
                    // Create a new thread to handle the client
                    clientHandler clientHandler = new clientHandler(clientSocket);
                    new Thread(clientHandler).start();
                    clientList.add(clientHandler);
                    

                } catch (IOException e) {
                    System.err.println("Error accepting client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        } finally {
            System.out.println("bye");
        }

    }

    static void broadcastMessage(String message) {
        for (clientHandler handler : clientList) {
            if (handler != null) {
                handler.sendMessage(message);
            }
            System.out.println(message);
        }
    }

    static void removeClient(clientHandler tgtHandler) {
        int index = clientList.indexOf(tgtHandler);
        if (index > 0) {
            clientList.remove(index);
        }

    }
}