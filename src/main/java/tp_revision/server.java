package tp_revision;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        ServerSocket server;
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
        try {
            System.out.println("Iam waiting for clients ... ");
            server = new ServerSocket(4545);
            while (true) {
                socket = server.accept();
                System.out.println("new client joins");
                // ClientHandler handler = new ClientHandler(socket);
                DistanceHandler handler = new DistanceHandler(socket);
                Thread mythread = new Thread(handler);
                mythread.start();
            }
        } catch (Exception ex) {
            System.out.println("error: " + ex);
        }
    }
}