import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by jsh3571 on 14/11/2016.
 */

public class Main {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("mail.comtrue.com", 110);

            BufferedReader sender
                    = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader receiver
                    = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));

            while (true) {
                System.out.println("input the data u want to send to echo server: ");
                String s = sender.readLine();

                if (s.equals("exit"))
                    System.exit(1);

                String st = receiver.readLine();
                System.out.println("data returned by the server:   ");
                System.out.println(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
