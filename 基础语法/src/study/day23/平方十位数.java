package study.day23;

import javax.swing.*;

/**
 由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。
 这其中也有很多恰好是平方数（是某个数的平方）。

 比如：1026753849，就是其中最小的一个平方数。

 请你找出其中最大的一个平方数是多少？
 */
public class 平方十位数 {
    static int max=Integer.MIN_VALUE;
    static long res;
    public static void main(String[] args) {
        int []data={0,1,2,3,4,5,6,7,8,9};
        dfs(0,data);
        System.out.println(res);
    }

    private static void dfs(int i, int[] data) {
        if (i==data.length){
            if (data[0]==0)return;
            int a=check(data);
            if (a>max){
                max=a;
                String s="";
                for (int j = 0; j <data.length ; j++) {
                    s+=data[j];
                }
                res=Long.parseLong(s);
            }
            return;
        }
        for (int j = i; j <data.length; j++) {
            int temp=data[i];
            data[i]=data[j];
            data[j]=temp;
            dfs(i+1,data);
            temp=data[i];
            data[i]=data[j];
            data[j]=temp;
        }
    }

    private static int check(int[] data) {
        String s="";
        for (int j = 0; j <data.length ; j++) {
            s+=data[j];
        }
        Long a=Long.parseLong(s);
        double b=Math.sqrt(a);
        String c=String.valueOf(b);
        int index=c.indexOf(".");
        long d=Long.parseLong(c.substring(index+1));
        if (d>0){
            return 0;
        }
        return (int)b;
    }
}
