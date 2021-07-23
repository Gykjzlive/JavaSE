package study.day1;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class day01 {
    public static void main(String[] args){

    }
    @Test
    public void test() throws IOException {
        BufferedReader  br=new BufferedReader(new FileReader("src\\study\\day1\\hello"));
        BufferedWriter  bw=new BufferedWriter(new FileWriter("src\\study\\day1\\hello2"));
        try {
            Map<Character,Integer> map=new HashMap();
            int c=0;
            while((c=br.read())!=-1){
                char data=(char)c;
                if(map.get(data)!=null){
                    map.put(data,map.get(data)+1);
                }else {
                    map.put(data,1);
                }
            }
            Set<Character> set=map.keySet();
            for (Character a:set){
                switch (a){
                    case ' ':
                        bw.write("空格:"+map.get(a));
                        break;
                    case '\t':
                        bw.write("tab键:"+map.get(a));
                        break;
                    case '\n':
                        bw.write("换行:"+map.get(a));
                        break;
                    case '\r':
                        bw.write("回车键:"+map.get(a));
                        break;
                    default:
                        bw.write(a+":"+map.get(a));
                        break;
                }
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
