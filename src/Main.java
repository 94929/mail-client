import java.io.*;
import java.net.Socket;

/**
 * Created by jsh3571 on 14/11/2016.
 */

public class Main {
    private static Socket client;
    private static BufferedReader message_receiver;

    private static final BufferedReader input_receiver
            = new BufferedReader(new InputStreamReader(System.in));

    private static String message;

    public static void main(String[] args) {
        try {
            System.out.print("Input \"MailServer\" and \"PortNumber\" in order to open a connection : ");
            message = input_receiver.readLine();

            client = new Socket(message.split(" ")[0], Integer.parseInt(message.split(" ")[1]));

            message_receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintStream ps = new PrintStream(client.getOutputStream());

            while (true) {
                System.out.println(message_receiver.readLine());

                message = input_receiver.readLine();

                if (message.equals("exit"))
                    System.exit(1);

                ps.println(message);

                message = message_receiver.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
