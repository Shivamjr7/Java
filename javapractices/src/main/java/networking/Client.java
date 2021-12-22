package networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;


    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());


        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        String line = "";
        while (!line.equals("exit")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (Exception e) {

            }
        }


        try {
            out.close();
            input.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 4000);
    }
}
