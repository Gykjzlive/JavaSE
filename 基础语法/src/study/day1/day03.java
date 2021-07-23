package study.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/5/9 11:14
 */
public class day03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= null;
        try {
            InputStreamReader isr=new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                System.out.println("请输入字符串:");
                String data=br.readLine();
                if("e".equalsIgnoreCase(data)||"exit".equalsIgnoreCase(data)){
                    System.out.println("程序结束");
                    break;
                }
                String s=data.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                br.close();
            }
        }
    }
}
