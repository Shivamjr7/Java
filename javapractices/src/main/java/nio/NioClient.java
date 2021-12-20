package nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class NioClient {


    public static void main(String[] args) throws IOException {

        InetSocketAddress address = new InetSocketAddress("127.0.0.1",12345);
        // creating a channel to write request to
        SocketChannel socketChannel = SocketChannel.open(address);

        Socket socket = socketChannel.socket();

        CharBuffer buffer = CharBuffer.allocate(1024);
        //flip so the buffer posn is set to 0 so it can read from start
        buffer.put("Hello from client...").flip();
        socketChannel.write(StandardCharsets.UTF_8.encode(buffer));

        System.out.println("Request sent to server...");
        socket.close();

    }
}
