package networking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    private Socket socket = null;

    private ServerSocket serverSocket = null;
    private DataInputStream in       =  null;

    public Server(int port)
    {
        try {

             serverSocket  = new ServerSocket(port) ;
             socket = serverSocket.accept();
             in = new DataInputStream( new BufferedInputStream(socket.getInputStream()));

             String line  ="";
             while(!line.equals("exit"))
             {
                 try{
                     line = in.readUTF();
                     System.out.println(line);
                 }
                 catch (Exception e)
                 {
                     e.printStackTrace();
                 }
             }
             socket.close();
             in.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Server server = new Server(4000);
    }
}
