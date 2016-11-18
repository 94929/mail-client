import java.io.*;
import java.net.Socket;

/**
 * Created by jsh3571 on 14/11/2016.
 */

public class Main {
    private static Socket client;

    public static void main(String[] args) {
        try {
            client = new Socket("mail.comtrue.com", 110);

            BufferedReader sender =
                    new BufferedReader(new InputStreamReader(System.in));

            BufferedReader receiver =
                    new BufferedReader(
                            new InputStreamReader(client.getInputStream()));

            System.out.println("Message received from the server : "+ receiver.readLine());

            while (true) {
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
