package study.day20;


/**
 * 把 2019 分解成 3 个各不相同的正整数之和，并且要求每个正整数都不包
 * 含数字 2 和 4，一共有多少种不同的分解方法？
 * 注意交换 3 个整数的顺序被视为同一种方法，例如 1000+1001+18 和
 * 1001+1000+18 被视为同一种。
 */
public class 数的分解 {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1; i <= 2019; i++) {
            for (int j = 1; j <= 2019; j++) {
                if (j == i) continue;
                for (int m = 1; m <= 2019; m++) {
                    if (m == j || m == i) continue;
                    if (i + j + m == 2019 && check(i) && check(j) && check(m)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count / 6);
    }

    private static boolean check(int i) {
        while (i > 0) {
            if (i % 10 == 2 || i % 10 == 4) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
