package study.day21;

/**
 学习了约数后，小明对于约数很好奇，他发现，给定一个正整数 t，总是可
 以找到含有 t 个约数的整数。小明对于含有 t 个约数的最小数非常感兴趣，并
 把它定义为 S t 。
 例如 S 1 = 1, S 2 = 2, S 3 = 4, S 4 = 6，· · · 。
 现在小明想知道，前 60 个 S i 的和是多少？即 S 1 + S 2 + · · · + S 60 是多少？
 */
public class 序列求和 {
    public static void main(String[] args) {
        int res = 0;
        int[] cnt = new int[62];
        for (int i = 1; true; i++) {
            int tmp = factors(i);
            if (tmp >= 60) {
                cnt[60] = cnt[61] = i;
                break;
            }
            if (cnt[tmp] == 0) cnt[tmp] = i;
        }
        System.out.println(cnt[60]);
        for (int i = 60; i > 0; i--) {
            if (cnt[i] == 0 || cnt[i] > cnt[i + 1]) cnt[i] = cnt[i + 1];
            res += cnt[i];
        }
        System.out.print(res);
    }

    static int factors(long n) {
        int res = 1, now;
        for (int i = 2; i * i <= n; i++) {
            now = 0;
            while (n % i == 0) {
                now++;
                n /= i;
            }
            if (now > 0) {
                res *= now + 1;
            }
        }
        return n <= 1? res: (res << 1);
    }
}
