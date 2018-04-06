import java.net.*;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.err.println("Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostname = args[0];
        int port = Integer.parseInt(args[1]);

        try(Socket socket = new Socket(hostname, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        ) {
            String input;
            while((input = stdIn.readLine()) != null) {
                out.println(input);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostname);
            System.exit(1);
        } 
    }
}

