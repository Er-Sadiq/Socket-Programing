import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        try {
            System.out.println("Server is started");
            ServerSocket serSocket = new ServerSocket(9999);
            System.out.println("Server Socket is created");
            
            System.out.println("Waiting for connection");
            
            Socket sock = serSocket.accept();
            System.out.println("Client is connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String receivedData = br.readLine(); // Read the data sent by the client
            System.out.println("Received data from client: " + receivedData);

            // You can process the received data here as needed

            br.close();
            sock.close();
            serSocket.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
