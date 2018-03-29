import java.io.*;

public class CharStreamDemo {
    public static void main(String[] args) {

        try(FileReader in = new FileReader("xanadu.txt");
            FileWriter out = new FileWriter("charout.txt")) {

            int c;
            while( (c = in.read()) != -1 ) {
                System.out.print(c + " ");
                out.write(c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("At least one of the input/output file doesn't exist");
        }

        // Let's see what happens with ByteStream
        try(FileInputStream in = new FileInputStream("xanadu.txt");
            FileOutputStream out = new FileOutputStream("byteout.txt")) {

            int c ;
            while((c = in.read()) != -1) {
                System.out.print(c + " ");
                out.write(c);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("At least one of the input/output file doesn't exist");
        }
    }
}

