package tp_revision;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class client2 {
    public static void main(String[] args) {
        Socket socket;
        DataInputStream in;
        DataOutputStream out;
             try {
            socket = new Socket("localhost", 4545);
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                // Mathematique operation using tcp/ip
                // float a= 5.8f;
                // float b= 8.5f;
                // int op=4;
                // out.writeFloat(a);
                // out.writeFloat(b);
                // out.writeInt(op);
                // boolean state = in.readBoolean();
                // System.out.println(state);
                // if (state) {
                // float res= in.readFloat();
                // System.out.println("result = "+res);
                // System.out.println("operation complete succeefully");
                // } else {
                // System.out.println("operation not possible , check numbers and operation type
                // !!");
                // }
                ////////////////////

                float x1 = 5.8f;
                float y1 = 8.5f;
                float x2 = 10.8f;
                float y2 = 5.5f;
                out.writeFloat(x1);
                out.writeFloat(y1);
                out.writeFloat(x2);
                out.writeFloat(y2);
                float res = in.readFloat();
                System.out.println("Distance between the points = " + res + " cm");
                System.out.println("operation complete succeefully");

            } finally {
                socket.close();
            }
            } catch(Exception ex){
                System.out.println("error :"+ex);
            }
    
    }
}
