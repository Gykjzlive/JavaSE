package study.day21;

import java.io.IOException;
import java.io.InputStream;

/**
 在一个 N × N 的点阵上，取其中 4 个点恰好组成一个正方形的 4 个顶点，一共有多少种不同的取法？
 由于结果可能非常大，你只需要输出模 109 + 7 的余数。
 对于所有评测用例，2 ≤ N ≤ 1000000。
 */
public class 数正方形 {
    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        long n = nextInt(System.in);
        long res = ((n - 1)* (n - 1)) % mod;
        for (int i = 2; i < n; i++)
            res = (res + (((n - i) * (n - i)) % mod) * i) % mod;
        System.out.println(res);
    }

    static int nextInt(InputStream in) throws IOException {
        int n = 0, c = in.read();
        while (c < '0' || c > '9') c = in.read();
        while (c >='0' && c <='9') {
            n = n * 10 + (c & 0xf);
            c = in.read();
        }
        return n;
    }
}
