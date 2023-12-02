package tp_revision;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class DistanceHandler implements Runnable {
    private Socket socket;

    public DistanceHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream in;

            in = new DataInputStream(socket.getInputStream());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            float x1 = in.readFloat();
            float y1 = in.readFloat();
            float x2 = in.readFloat();
            float y2 = in.readFloat();
            float xlength=((float)Math.pow(x2-x1, 2));
            float ylength=((float)Math.pow(y2-y1, 2));
            float res= (float) Math.sqrt(xlength+ylength);
            System.out.println(res);
            out.writeFloat(res);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
