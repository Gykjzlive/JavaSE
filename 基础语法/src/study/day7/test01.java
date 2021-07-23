package study.day7;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("(1-9999)请输入一个数:");
        int data = s.nextInt();
        if (data < 1 || data > 9999) {
            System.out.println("输入得数不符合规范，请重新输入");
            data = s.nextInt();
        }
        int[] arr = new int[4];
        int i = 0, j;
        while (data != 0) {
            arr[i] = data % 10;
            data /= 10;
            i++;
        }
        boolean flag = true;
        for (j = 0; j < i / 2; j++) {
            if (arr[j] != arr[i - j - 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("是回文数");
        } else {
            System.out.println("不是回文数");
        }
    }
}
