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
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) throws IOException {

        //creating a server socket channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //getting the socket
        ServerSocket serverSocket = serverSocketChannel.socket();

        //to allow non blocking operations
        serverSocketChannel.configureBlocking(false);
        //binding socket to a address
        serverSocket.bind(new InetSocketAddress("127.0.0.1",12345));

        //creating a selector to handle the channel
        Selector selector = Selector.open();
        //register socket channel to selector to accept connection
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("Server started");
        while (true) {
            // this will give the number of events received by selector
            //Use the Selector's select() method: The select() method blocks until at least one channel has a pending event.
            //It returns a count of the number of channels that have pending events.
            //The Selector uses a native system call such as epoll, kqueue or poll to monitor multiple channels
            int numberofEvents = selector.select(); //blocking call

            System.out.println("No of events received : " + numberofEvents);

            Set<SelectionKey> set = selector.selectedKeys(); //non blocking

            //iterating through the events received
            // do iterator

            Iterator<SelectionKey> itr = set.iterator();

            while(itr.hasNext())
            {
                SelectionKey key = itr.next();

                //if it is accept event
                if (key.isAcceptable()) {
                    System.out.println("Accepting connection from client...");
                    ServerSocketChannel channel = (ServerSocketChannel) key.channel(); //getting the channel where event arrived

                    //this channel will be used for commnunication with the client
                    SocketChannel socketChannel = channel.accept();
                    socketChannel.configureBlocking(false);
                    //now since we are communicating we are going to read the incoming request in this channel
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    //since we handled the event we can remove the key
                    itr.remove();
                } else if (key.isReadable()) {
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
                    itr.remove();
                    key.cancel();
                    channel.close();
                }

            }
//            for (SelectionKey key : set) {
//
//            }

        }



    }
}
