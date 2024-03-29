import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {

    // port number 0-1023 are reserved, there are a total of 65535 ports
    public static void main(String[] args) {
        String ip = "localhost";
        int port = 9999;

        try (Socket client = new Socket(ip, port)) {
            String str = "Hello";
            // convert data into stream format // output port
            OutputStreamWriter convertedOutput = new OutputStreamWriter(client.getOutputStream()); // from where you want to send this data
            // sending data
            PrintWriter send = new PrintWriter(convertedOutput);
            send.println(str); // Use PrintWriter to send data
            send.flush(); // Flush the PrintWriter to ensure the data is sent
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
