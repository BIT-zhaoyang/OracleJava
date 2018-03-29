import java.io.*;
import java.util.Scanner;
import java.util.Locale;

public class ScannerDemo {
    public static void main(String[] args) {
        // Scanner parse input
        try(FileReader in = new FileReader("xanadu.txt");
            BufferedReader buffIn = new BufferedReader(in);
            Scanner s = new Scanner(buffIn);) {

            while(s.hasNext()) {
                System.out.println(s.next());
            }
         } catch (IOException e) {
                System.out.println("Input file doesn't exist");
         }

        // Scanner translate input
        try(FileReader in = new FileReader("usnumbers.txt");
            BufferedReader buffIn = new BufferedReader(in);
            Scanner s = new Scanner(buffIn);) {

            double sum = 0.0d;
            s.useLocale(Locale.US);
            //s.useLocale(Locale.GERMAN);
            while(s.hasNext()) {
                if(s.hasNextDouble()) {
                    double next = s.nextDouble();
                    sum += next;
                    System.out.print("Get next double: ");
                    System.out.println(next);
                } else {
                    String next = s.next();
                    System.out.print("Get next String: ");
                    System.out.println(next);
                }
            }

            System.out.println(sum);
         } catch (IOException e) {
                System.out.println("Input file doesn't exist");
         }
    }
}
