package study.day20;

/**
 * 观察下面的加法算式：
 * <p>
 * 祥 瑞 生 辉
 * +   三 羊 献 瑞
 * -------------------
 * 三 羊 生 瑞 气
 * a b c d
 * + e f g b
 * e f c b k
 * <p>
 * 其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
 * <p>
 * 请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
 */
public class 三羊献瑞 {
    public static void main(String[] args) {
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (b == a) continue;
                for (int c = 0; c < 10; c++) {
                    if (c == a || c == b) continue;
                    for (int d = 0; d < 10; d++) {
                        if (d == a || d == b || d == c) continue;
                        for (int e = 0; e < 10; e++) {
                            if (e == d || e == a || e == b || e == c) continue;
                            for (int f = 0; f < 10; f++) {
                                if (f == d || f == a || f == b || f == c || f == e) continue;
                                for (int g = 0; g < 10; g++) {
                                    if (g == d || g == a || g == b || g == c || g == e || g == f) continue;
                                    for (int k = 0; k < 10; k++) {
                                        if (k == d || k == a || k == b || k == c || k == e || k == f || k == g)
                                            continue;
                                        /**
                                         a b c d
                                         + e f g b
                                         e f c b k
                                         */
                                        if ((a * 1000 + b * 100 + c * 10 + d) + (e * 1000 + f * 100 + g * 10 + b) == e * 10000 + f * 1000 + c * 100 + b * 10 + k) {
                                            System.out.println(a * 1000 + b * 100 + c * 10 + d);
                                            System.out.println(e * 1000 + f * 100 + g * 10 + b);
                                            System.out.println(e * 10000 + f * 1000 + c * 100 + b * 10 + k);
                                            System.out.println("*****************");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
