package study.day23;

import java.util.Scanner;

/**
 某次无聊中， atm 发现了一个很老的程序。这个程序的功能类似于 Excel ，它对一个表格进行操作。
 不妨设表格有 n 行，每行有 m 个格子。
 每个格子的内容可以是一个正整数，也可以是一个公式。
 公式包括三种：
 1. SUM(x1,y1:x2,y2) 表示求左上角是第 x1 行第 y1 个格子，右下角是第 x2 行第 y2 个格子这个矩形内所有格子的值的和。
 2. AVG(x1,y1:x2,y2) 表示求左上角是第 x1 行第 y1 个格子，右下角是第 x2 行第 y2 个格子这个矩形内所有格子的值的平均数。
 3. STD(x1,y1:x2,y2) 表示求左上角是第 x1 行第 y1 个格子，右下角是第 x2 行第 y2 个格子这个矩形内所有格子的值的标准差。

 标准差即为方差的平方根。
 方差就是：每个数据与平均值的差的平方的平均值，用来衡量单个数据离开平均数的程度。

 公式都不会出现嵌套。

 如果这个格子内是一个数，则这个格子的值等于这个数，否则这个格子的值等于格子公式求值结果。

 输入这个表格后，程序会输出每个格子的值。atm 觉得这个程序很好玩，他也想实现一下这个程序。

 「输入格式」
 第一行两个数 n, m 。
 接下来 n 行输入一个表格。每行 m 个由空格隔开的字符串，分别表示对应格子的内容。
 输入保证不会出现循环依赖的情况，即不会出现两个格子 a 和 b 使得 a 的值依赖 b 的值且 b 的值依赖 a 的值。

 「输出格式」
 输出一个表格，共 n 行，每行 m 个保留两位小数的实数。
 数据保证不会有格子的值超过 1e6 。

 「样例输入」
 3 2
 1 SUM(2,1:3,1)
 2 AVG(1,1:1,2)
 SUM(1,1:2,1) STD(1,1:2,2)

 「样例输出」
 1.00 5.00
 2.00 3.00
 3.00 1.48
 */
public class 表格计算 {
    static int n,m;
    static String[][] data;
    static double [][] result;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        data=new String[n][m];
        result=new double[n][m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                data[i][j]=scanner.next();
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                if(Character.isDigit(data[i][j].charAt(0))){
                    result[i][j]=Integer.parseInt(data[i][j]);
                }else {
                    result[i][j]=f(data[i][j]);
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.printf("%.2f ",result[i][j]);
            }
            System.out.println();
        }
    }

    private static double f(String s) {
        int a[]=new int[4];
        a[0]=s.charAt(4)-'0';
        a[1]=s.charAt(6)-'0';
        a[2]=s.charAt(8)-'0';
        a[3]=s.charAt(10)-'0';
        if (s.startsWith("SUM")){
            return SUM(a);
        }
        if (s.startsWith("AVG")){
            return AVG(a);
        }
        if (s.startsWith("STD")){
            return STD(a);
        }
        return 0;
    }

    private static double STD(int[] a) {
        double avg=AVG(a);
        double sum=0;
        int count=(a[2]-a[0]+1)*(a[3]-a[1]+1);
        for (int i = a[0]-1; i <a[2] ; i++) {
            for (int j =a[1]-1; j <a[3] ; j++) {
                if (Character.isDigit(data[i][j].charAt(0))){
                    sum+=Math.pow(Math.abs(avg-Double.parseDouble(data[i][j])),2);
                }else {
                    sum+=Math.pow(Math.abs(avg-f(data[i][j])),2);
                }
            }
        }
        return Math.sqrt(sum/count);
    }

    private static double AVG(int[] a) {
        double ans=SUM(a);
        int count=(a[2]-a[0]+1)*(a[3]-a[1]+1);
        return ans/count;
    }

    private static double SUM(int[] a) {
        int ans=0;
        for (int i = a[0]-1; i <a[2] ; i++) {
            for (int j =a[1]-1; j <a[3] ; j++) {
                if (Character.isDigit(data[i][j].charAt(0))){
                    ans+=Double.parseDouble(data[i][j]);
                }else {
                    ans+=f(data[i][j]);
                }
            }
        }
        return ans;
    }
}
