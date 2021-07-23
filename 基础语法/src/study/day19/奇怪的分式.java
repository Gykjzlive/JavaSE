package study.day19;

import sun.applet.Main;

public class 奇怪的分式 {
    public static void main(String[] args) {
        int count = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                if (a == b) continue;
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        if (c == d) continue;
                        int num1 = gcd(a * c, b * d);
                        int num2 = gcd(a * 10 + c, b * 10 + d);
                        if ((a * c) / num1 == (a * 10 + c) / num2 && (b * d) / num1 == (b * 10 + d) / num2) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
