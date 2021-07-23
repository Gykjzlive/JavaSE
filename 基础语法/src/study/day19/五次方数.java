package study.day19;

public class 五次方数 {
    public static void main(String[] args) {
        for (int i = 4150; i <= 194979; i++) {
            if (wcf(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean wcf(int n) {
        int sum = 0, t = n;
        while (n != 0) {
            int temp = n % 10;
            sum += Math.pow(temp, 5);
            n = n / 10;
        }
        if (sum == t) {
            return true;
        } else {
            return false;
        }
    }
}