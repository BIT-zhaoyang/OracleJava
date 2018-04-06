import java.io.*;
import java.net.*;

public class KKMultiServer {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Usage: java KKMultiServer <port number>");
            System.exit(1);
        }

        int portNumber = Integer.parseInt(args[0]);
        try(ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while(true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Build a connection with server address: " + clientSocket.getLocalSocketAddress());
                    System.out.println("Build a connection with client address: " + clientSocket.getRemoteSocketAddress());
                    KKMultiServerThread thread = new KKMultiServerThread(clientSocket);
                    (new Thread(thread)).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
