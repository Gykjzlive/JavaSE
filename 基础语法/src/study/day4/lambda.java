package study.day4;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/6/1 8:56
 */
public class lambda {
    public static void main(String[] args) {
         Function<Integer,String[]> fun=new Function<Integer, String[]>() {
             @Override
             public String[] apply(Integer integer) {
                 return new String[integer];
             }
         };
         String[] a=fun.apply(5);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("...........................");
        Function<Integer,String[]> fun2=integer->new String[integer];
        String[] b=fun.apply(7);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i]+" ");
        }
        System.out.println("...........................");
        Function<Integer,String[]> fun3=String[]::new;
        String[] c=fun.apply(10);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]+" ");
        }
    }
}
