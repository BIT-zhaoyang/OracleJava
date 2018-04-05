import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) {
        String address = "https://docs.oracle.com/javase/tutorial/networking/urls/connecting.html";
        URL oracle = null;
        try{
            oracle = new URL(address);
        } catch (MalformedURLException e) {
            System.out.println("Check the form of URL");
        }

        try(InputStreamReader ins = new InputStreamReader(oracle.openStream());
            BufferedReader  in = new BufferedReader(ins);) {

            String line;
            while( (line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
