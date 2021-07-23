package study.day19;

import java.math.BigInteger;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: TODO
 * @date 2021/3/28 19:06
 */
public class 复数幂 {
    /**
     * 设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
     * 求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。
     * 答案写成 “实部±虚部i” 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
     * (2+3i)^5 的写成: 122-597i
     */
    public static void main(String[] args) {
        BigInteger a = BigInteger.valueOf(2);
        BigInteger b = BigInteger.valueOf(3);
        for (int i = 1; i <= 123455; i++) {
            BigInteger c = a;
            a = a.multiply(BigInteger.valueOf(2)).subtract(b.multiply(BigInteger.valueOf(3)));
            b = c.multiply(BigInteger.valueOf(3)).add(b.multiply(BigInteger.valueOf(2)));
        }
        System.out.println(a + (b.compareTo(BigInteger.ZERO) > 0 ? "+" : "-") + b + "i");
    }
}
