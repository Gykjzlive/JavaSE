package study.day19;

import java.util.Scanner;

public class 饮料换购 {
    /*
        问题描述
        乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去，但不允许赊账。
        请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的n瓶饮料，最后他一共能得到多少瓶饮料。
        输入格式:
        一个整数n，表示开始购买的饮料数量（0<n<10000）

        输出格式:
        一个整数，表示实际得到的饮料数

        输入样例:
        在这里给出一组输入。例如：
        100

        输出样例:
        在这里给出相应的输出。例如：
        149
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int count = 0;
        if (n > 0 && n < 10000) {
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0) {
                    n++;
                }
                count++;
            }
        }
        System.out.println(count);
    }
}
