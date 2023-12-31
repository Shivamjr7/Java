package networking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {

    private Socket socket = null;

    private ServerSocket serverSocket = null;
    private DataInputStream in       =  null;


    public static void main(String[] args) {
        ServerTest server = new ServerTest();
        server.runServer();
    }

    public void runServer()
    {
        ServerSocket serverSocket;
        try {
           serverSocket  = new ServerSocket(4000);
            while(true)
            {
                //accepting the connection
               Socket socket  =  serverSocket.accept();

                System.out.println("Connection accepted ....");

                System.out.println("Now we can chat with the sever using this socket "+ socket);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
