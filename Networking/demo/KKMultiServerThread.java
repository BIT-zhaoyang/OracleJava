import java.io.*;
import java.net.*;

public class KKMultiServerThread implements Runnable{
    private Socket clientSocket;
    
    public KKMultiServerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try(PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine, outputLine;

            KnockKnockProtocol kkp = new KnockKnockProtocol();
            outputLine = kkp.processInput(null);
            out.println(outputLine);

            while((inputLine = in.readLine()) != null) {
                outputLine = kkp.processInput(inputLine);
                out.println(outputLine);
                if(outputLine.equals("Bye."))
                    break;
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

