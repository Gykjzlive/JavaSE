package study.day19;
/*
如图，如下的10个格子，填入0~9的数字。要求：连续的两个数字不能相邻。
（左右、上下、对角都算相邻）一共有多少种可能的填数方案？
请填写表示方案数目的整数。
  +--+--+--+
    | 0 | 1 | 2 |
+--+--+--+--+
| 3 | 4 | 5 | 6 |
+--+--+--+--+
| 7 | 8 | 9 |
+--+--+--+
 */

public class 方格填数 {
    static int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int count;

    public static void main(String[] args) {
        f(0);
        System.out.println(count);
    }

    private static void f(int i) {
        if (i == 10) {
            if (check()) {
                count++;
            }
            return;
        }
        for (int j = i; j < 10; j++) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            f(i + 1);
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    private static boolean check() {
        if (
                Math.abs(a[0] - a[1]) == 1 || Math.abs(a[0] - a[3]) == 1 || Math.abs(a[0] - a[4]) == 1 || Math.abs(a[0] - a[5]) == 1 ||
                        Math.abs(a[1] - a[2]) == 1 || Math.abs(a[1] - a[4]) == 1 || Math.abs(a[1] - a[5]) == 1 || Math.abs(a[1] - a[6]) == 1 ||
                        Math.abs(a[2] - a[5]) == 1 || Math.abs(a[2] - a[6]) == 1 ||
                        Math.abs(a[3] - a[4]) == 1 || Math.abs(a[3] - a[7]) == 1 || Math.abs(a[3] - a[8]) == 1 ||
                        Math.abs(a[4] - a[5]) == 1 || Math.abs(a[4] - a[7]) == 1 || Math.abs(a[4] - a[8]) == 1 || Math.abs(a[4] - a[9]) == 1 ||
                        Math.abs(a[5] - a[6]) == 1 || Math.abs(a[5] - a[9]) == 1 || Math.abs(a[5] - a[8]) == 1 ||
                        Math.abs(a[6] - a[9]) == 1 ||
                        Math.abs(a[7] - a[8]) == 1 ||
                        Math.abs(a[8] - a[9]) == 1
        ) {
            return false;
        }
        return true;
    }
}
