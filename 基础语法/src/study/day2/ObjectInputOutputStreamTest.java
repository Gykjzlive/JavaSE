package study.day2;

import java.io.*;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/10 11:08
 */
public class ObjectInputOutputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("D:\\JavaSE\\基础语法\\src\\study\\day2\\hello"));
            int c= objectInputStream.read();
            System.out.println((char)c);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
