package Default;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Project06A_Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 9999);// ----> accept() 서버 연결
            System.out.println("Connection Success!");
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();
            OutputStream out = socket.getOutputStream(); //서버에 보내기 위해 먼저 Out먼저
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(message);

            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            System.out.println("Receive:"+dis.readUTF());

            dis.close();
            dos.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
