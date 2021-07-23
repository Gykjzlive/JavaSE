package study.day3;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/15 13:38
 */
public class InteAddress {
    @Test
    public void client() throws IOException {
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress=InetAddress.getByName("100.68.203.164");
            socket = new Socket(inetAddress, 8899);
            outputStream = socket.getOutputStream();
            outputStream.write("你好,李加加".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputStream!=null){
                outputStream.close();
            }
            if (socket!=null){
                socket.close();
            }
        }
    }
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = null;
        Socket socket= null;
        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            serverSocket = new ServerSocket(8899);
            socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] data=new byte[5];
            int len;
            while ((len=inputStream.read(data))!=-1){
                byteArrayOutputStream.write(data,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            byteArrayOutputStream.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        }
    }
}
