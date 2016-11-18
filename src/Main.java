import java.io.*;
import java.net.Socket;

/**
 * Created by jsh3571 on 14/11/2016.
 */

public class Main {
    private static Socket client;
    private static BufferedReader receiver;

    private static BufferedReader sender
            = new BufferedReader(new InputStreamReader(System.in));

    private static String message;

    public static void main(String[] args) {
        try {
            System.out.print("Input \"MailServer\" and \"PortNumber\" in order to open a connection : ");
            message = sender.readLine();

            client = new Socket(message.split(" ")[0], Integer.parseInt(message.split(" ")[1]));

            receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println("Message received from the server : "+ receiver.readLine());

            while (true) {
                //
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
