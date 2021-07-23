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
 * @date 2021/5/18 9:40
 */
public class InetAdressTwo {
    public static void main(String[] args) {

    }
    @Test
    public void client() throws IOException {
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,9779);
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(new File("src\\study\\day3\\111.jpg"));
            byte []data= new byte[1024];
            int len;
            while((len=fileInputStream.read(data))!=-1){
                outputStream.write(data,0,len);
            }
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes=new byte[5];
            while((len=inputStream.read(bytes))!=-1){
                byteArrayOutputStream.write(bytes,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
        fileInputStream.close();
        socket.close();
        outputStream.close();
    }
    @Test
    public void server() throws IOException{
        ServerSocket serverSocket = new ServerSocket(9779);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("src\\study\\day3\\333.jpg"));
        byte[] data=new byte[1024];
        int len;
        while((len=inputStream.read(data))!=-1){
            fileOutputStream.write(data,0,len);
        }
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("收到".getBytes());
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
