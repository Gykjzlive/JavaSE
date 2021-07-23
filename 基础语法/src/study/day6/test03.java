package study.day6;


public class test03 {
    public static void main(String[] args) {
        int i, a, b, c, sum;
        System.out.println("水仙花数有：");
        for (i = 100; i <= 999; i++) {
            a = i / 100;
            b = i % 100 / 10;
            c = i % 100 % 10;
            sum = a * a * a + b * b * b + c * c * c;
            if (sum == i) {
                System.out.print(sum + "\t");
            }
        }
    }
}
