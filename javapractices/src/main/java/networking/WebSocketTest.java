//package networking;
//
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.ArrayList;
//import java.util.List;
//
//public class WebSocketTest {
//
//
//    public static void main(String[] args) {
//
//
//        List<Socket> connections = new ArrayList<>();
//        try {
//            ServerSocket socket = new ServerSocket(8080);
//
//            while (true)
//            {
//
//                Socket clientsocket = socket.accept();
//
//                connections.add(clientsocket);
//
//
//
//                connections.forEach(s->{
//                  s.getOutputStream().write();
//                });
//
//
//            }
//        }
//        catch(Exception e)
//        {
//
//        }
//
//    }
//
//}
