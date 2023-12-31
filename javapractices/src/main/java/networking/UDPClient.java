package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {


    public static void main(String[] args) {

        UDPClient client = new UDPClient();
        client.runClient();
    }

    public void runClient()
    {
        try {
            DatagramSocket clientsocket = new DatagramSocket();

            InetAddress address = InetAddress.getByName("localhost");

            byte[] request = new byte[1024];
            byte[] response = new byte[1024];

            String str = "I am a UDP Client";
            request = str.getBytes();

            DatagramPacket sendingPacket = new DatagramPacket(request,request.length,address,5443);
            clientsocket.send(sendingPacket);


            DatagramPacket rcvngPacket = new DatagramPacket(response,response.length);
            clientsocket.receive(rcvngPacket);

            String recvd = new String(rcvngPacket.getData());
            System.out.println("response rcvd from server : "+ recvd);
                clientsocket.close();

        }
        catch (IOException e)
        {

        }

    }
}
