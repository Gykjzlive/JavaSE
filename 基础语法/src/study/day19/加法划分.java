package study.day19;

import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description:
 * @date 2021/3/22 7:34
 */
public class 加法划分 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] array = new int[n];
        f(n, array, 0);
    }

    private static void f(int n, int[] array, int index) {
        if (n == 0) {
            boolean flag = check(array, index);
            if (flag) {
                for (int i = 0; i < index; i++) {
                    if (i == index - 1) {
                        System.out.println(array[i]);
                    } else {
                        System.out.print(array[i] + "+");
                    }
                }
            }
            return;
        }
        for (int i = n; i > 0; i--) {
            array[index] = i;
            f(n - i, array, index + 1);
        }
    }

    private static boolean check(int[] array, int index) {
        for (int i = 1; i < index; i++) {
            if (array[i] > array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
