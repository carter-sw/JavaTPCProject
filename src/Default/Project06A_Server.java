package Default;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Project06A_Server {
    public static void main(String[] args) {
        ServerSocket ss = null;
        try{
            ss= new ServerSocket(9999); //임의의 포트설정
            System.out.println("Server ready....");
        }catch (Exception e){
            e.printStackTrace();
        }
        while (true){
            try{
                Socket socket = ss.accept(); // 클라이언트 정보 가지고있는 소켓
                System.out.println("client connect success!");
                InputStream in = socket.getInputStream(); //한글을 읽어들이기 위해서 빨대생성
                DataInputStream dis = new DataInputStream(in);  // 변환 후 집어넣음
                String message = dis.readUTF();

                OutputStream out = socket.getOutputStream(); // 한글을 보내기 위해서 빨대생성
                DataOutputStream dos = new DataOutputStream(out); // 변환 후 보냄
                dos.writeUTF("[ECHO]"+message+"(from Server!)");
                dos.close();
                dis.close();
                socket.close();

                System.out.println("client socket close...");

            }catch (Exception e){
                e.printStackTrace();
            }
        } // while
    } // main
} // class
