import java.io.*;
import java.net.Socket;

/**
 * Created by jsh3571 on 14/11/2016.
 */

public class Main {
    private static Socket client;
    private static final BufferedReader br
            = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        try {
            /* Set up the connection to mail server from the command line */
            client = new Socket(args[0], Integer.parseInt(args[1]));

            /* Initialize 'ps' that sends message to the server */
            PrintStream ps = new PrintStream(client.getOutputStream());

            /* Initialize receiver that receives message from the server */
            BufferedReader receiver
                    = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));

            while (true) {
                /* Printing the resulting response from the server */
                System.out.println(receiver.readLine());

                /* Get input message from the user */
                String message = br.readLine();

                /* If the user inputs "exit", then the program terminates */
                if (message.equals("exit"))
                    System.exit(1);

                /* If not exit, send the message to server */
                ps.println(message);
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
