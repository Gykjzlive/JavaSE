package study.day5;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入年份");
        int year = s.nextInt();
        if (year % 4 == 0) {
            if (year % 400 == 0 && year % 100 != 0) {
                System.out.println("你输入的是闰年");
            } else {
                System.out.println("你输入的不是闰年");
            }
        } else {
            System.out.println("你输入的不是闰年");
        }

    }
}
