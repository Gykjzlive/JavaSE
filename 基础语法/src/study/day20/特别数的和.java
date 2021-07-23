package study.day20;

import java.util.Scanner;

/**
 * 小明对数位中含有 2、0、1、9 的数字很感兴趣（不包括前导 0），在 1 到
 * 40 中这样的数包括 1、2、9、10 至 32、39 和 40，共 28 个，他们的和是 574。
 * 请问，在 1 到 n 中，所有这样的数的和是多少？
 */
public class 特别数的和 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextInt();
        String[] array = {"2", "0", "1", "9"};
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String s1 = String.valueOf(i);
            for (int j = 0; j < array.length; j++) {
                if (s1.contains(array[j])) {
                    sum += i;
                    break;
                }
            }
        }
        System.out.println(sum);
    }
}
