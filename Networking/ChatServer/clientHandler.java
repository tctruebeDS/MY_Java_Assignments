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

        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("Connected to client " + clientSocket.getInetAddress().getHostAddress()
                    + " on port " + clientSocket.getPort());

            // String inputLine;
            
            // Print some info- internet address, name
            ChatServer.broadcastMessage(clientSocket.getInetAddress() + getName());
            // while ((inputLine = in.readLine()) != null) {
            //     // Print message to screen and then broadcast the message to everyone in the
            //     // arraylist
            //     String message = String.format("%s: %s", name, inputLine);

            //     ChatServer.broadcastMessage(message);

            // }
            System.out.println("Client disconnected: " + clientSocket.getInetAddress());
        } catch (IOException e) {
            System.err.println("Error handling client: " + e.getMessage());
        } finally {
            if (out != null) {
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