package study.day6;

import java.util.Scanner;

public class work03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("请输入塔的层数:");
        int data = s.nextInt();
        int i, j, k;
        for (i = 1; i <= data; i++) {
            for (j = 1; j <= data - i; j++) {
                System.out.print(" ");
            }
            for (k = 1; k <= i * 2 - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
