package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {


    public static void main(String[] args) throws IOException {

        UDPServer server = new UDPServer();
        server.runUPDServer();
    }

    public void runUPDServer() throws IOException {
        DatagramSocket socket = new DatagramSocket(5443);

        byte[] buff = new byte[1024];
        byte[] response = new byte[1024];

        boolean running= true;
        while (running)
        {
            DatagramPacket packet = new DatagramPacket(buff, buff.length);
            System.out.println("Server started on port 5443....");
            socket.receive(packet);

            String str = new String(packet.getData());
            System.out.println("Data recvd from client :");
            System.out.println(str);
            System.out.println("-------");
            if(str.equals("bye"))
            {
                System.out.println("Client going to disconnect");
                break;
            }
            System.out.println("client details : "+ packet.getAddress() +" port : "+ packet.getPort());

            response = "This is message from server".getBytes();

            System.out.println("Sending response to client ");

            DatagramPacket sendingPacket = new DatagramPacket(response,response.length,packet.getAddress(), packet.getPort());


            socket.send(sendingPacket);


        }

        socket.close();


    }
}
