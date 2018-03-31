import java.io.*;

class ByteStreamReader {
    public static void main(String[] args) {
        // The stream will automatically close with this 'try-with-resources'
        // syntax
        try (FileInputStream in = new FileInputStream("xanadu.txt");
             FileOutputStream out = new FileOutputStream("outagain.txt")) {

            boolean eof = false;
            while(!eof) {
                int byteValue = in.read();
                System.out.print(byteValue + " ");
                out.write(byteValue);
                if (byteValue == -1){
                    eof = true;
                    System.out.println("");
                }
            }

        } catch (IOException ioe) {
            System.out.println("Could not read file: " + ioe.toString());
        }
    }
}
