import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by jsh3571 on 14/11/2016.
 */

public class Main {

    public static void main(String[] args) {
        Socket client = null;
        try {
            client = new Socket("mail.comtrue.com", 110);

            while (true) {

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
