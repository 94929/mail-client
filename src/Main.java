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
            /* Input format checking before opening a connection,
                the input must be a form of mail_server and port_number */
            if (args.length != 2)
                System.exit(1);

            /* Set up the connection to mail server from the command line */
            client = new Socket(args[0], Integer.parseInt(args[1]));

            /* Initialize sender that sends message to the server */
            PrintStream sender = new PrintStream(client.getOutputStream());

            /* Initialize receiver that receives message from the server */
            BufferedReader receiver
                    = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));

            while (true) {
                /* Flushing buffer */
                String svrMsg;

                /* Waits for buffer */
                while (!receiver.ready()) {}

                /* Printing the resulting response from the server */
                while (receiver.ready()) {
                    svrMsg = receiver.readLine();
                    System.out.println(svrMsg);
                }

                /* Get input message from the user */
                String usrMsg = br.readLine();

                /* If the user inputs "exit", then the program terminates */
                if (usrMsg.equals("exit")) System.exit(1);

                /* If not exit, send the message to server */
                sender.println(usrMsg);
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
