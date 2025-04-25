import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class clientHandler implements Runnable {
    private Socket clientSocket;
    private String name;
    private PrintWriter out;
    private BufferedReader in;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public clientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        // use try with catch statement to create output and input streams.

        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Connected to client " + clientSocket.getInetAddress().getHostAddress()
                    + " on port " + clientSocket.getPort());

            String inputLine;

            // get name from the client.
            out.println("Enter your user name: ");
            name = in.readLine();

            System.out.printf("Client %s is using the name \"%s\"%n",
                    clientSocket.getInetAddress().getHostAddress(), name);
            ChatServer.broadcastMessage(name + " has joined the chat server!");

            while ((inputLine = in.readLine()) != null) {
                // Print message to screen and then broadcast the message to everyone in the
                // arraylist
                String message = String.format("%s: %s", name, inputLine);
                System.out.println("received - " + message);

                ChatServer.broadcastMessage(message);

            }
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    // Error closing stream
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    // Error closing stream
                }
            }
            ChatServer.removeClient(this);
        }
    }

    public void sendMessage(String message) {
        if (out != null) {
            out.println(message);
        }
    }

}