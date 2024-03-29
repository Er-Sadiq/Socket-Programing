import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        try {
            System.out.println("Serv : Server is started");
            ServerSocket serSocket = new ServerSocket(9999);
            System.out.println("Serv : Server Socket is created");

            System.out.println("Serv : Waiting for connection");
            Socket sock = serSocket.accept();
            
            System.out.println("Serv : Client is connected");

            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            String receivedData = br.readLine(); // Read the data sent by the client
            System.out.println("Serv : Received data from client: " + receivedData);

            // You can process the received data here as needed
             String subStr=receivedData.substring(0,2);

             // sending data to client
             OutputStreamWriter covertedData= new OutputStreamWriter(sock.getOutputStream());
             PrintWriter sendData = new PrintWriter(covertedData);
             sendData.println(subStr);
             sendData.flush();

             System.out.println("Serv : Data has been sent to clinet ");


            br.close();
            sock.close();
            serSocket.close();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
