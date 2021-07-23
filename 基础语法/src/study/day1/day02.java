package study.day1;

import java.io.*;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/9 10:05
 */
public class day02 {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr= null;
        OutputStreamWriter osw= null;
        try {
            FileInputStream fr=new FileInputStream("D:\\JavaSE\\基础语法\\src\\study\\day1\\hello");
            FileOutputStream fw=new FileOutputStream("D:\\JavaSE\\基础语法\\src\\study\\day1\\hello3");
            isr = new InputStreamReader(fr,"utf-8");
            osw = new OutputStreamWriter(fw,"gbk");
            char[] chars=new char[20];
            int len;
            while((len=isr.read(chars))!=-1){
                osw.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            isr.close();
            osw.close();
        }
    }
}
