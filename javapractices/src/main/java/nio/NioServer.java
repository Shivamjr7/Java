package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {

        //creating a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //getting the socket
        ServerSocket serverSocket = serverSocketChannel.socket();

        serverSocketChannel.configureBlocking(false);
        //binding socket to a address
        serverSocket.bind(new InetSocketAddress("127.0.0.1",12345));

        //creating a selector to handle the channel
        Selector selector = Selector.open();
        //register socket channel to selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started");
        while (true) {
            // this will give the number of events received by selector
            int numberofEvents = selector.select(); //blocking call

            System.out.println("No of events received : " + numberofEvents);

            Set<SelectionKey> set = selector.selectedKeys(); //non blocking

            //iterating through the events received
            for (SelectionKey key : set) {
                //if it is accept event
                if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
                    System.out.println("Accepting connection from client...");
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel(); //getting the channel where event arrived

                    //this channel will be used for commnunication with the client
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    //now since we are communicating we are going to read the incoming request in this channel
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    //since we handled the event we can remove the key
                    set.remove(key);
                } else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
                    //get the channel where request received

                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    //write to buffer
                    channel.read(buffer);

                    //flip the buffer to read
                    buffer.flip();

                    CharBuffer charBuffer = StandardCharsets.UTF_8.decode(buffer);
                    String request = new String(charBuffer.array());
                    System.out.println("Request Read : " + request);

                    //closing resources
                    buffer.clear();
                    set.remove(key);
                    key.cancel();
                    channel.close();
                }
            }

        }



    }
}
