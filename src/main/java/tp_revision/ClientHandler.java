package tp_revision;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream in;

            in = new DataInputStream(socket.getInputStream());

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            float a = in.readFloat();
            float b = in.readFloat();
            float res;
            int op = in.readInt();

            if ((op == 3 || op == 4) && (a == 0 || b == 0)) {
                out.writeBoolean(false);
            } else {
                switch (op) {
                    case 2:
                        res = a - b;
                        break;
                    case 3:
                        res = a * b;
                        break;
                    case 4:
                        res = a / b;
                        break;
                    default:
                        res = a + b;
                        break;
                }
                out.writeBoolean(true);
                System.out.println(res);
                out.writeFloat(res);
                System.out.println("operation complete succeefully");
                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
