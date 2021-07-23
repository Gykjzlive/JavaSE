package study.day6;

public class work01 {
    public static void main(String[] args) {
        int i, j;
        System.out.println("50到100之间的素数为：");
        for (i = 50; i <= 100; i++) {
            boolean flag = true;
            for (j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.print(i + "\t");
            }
        }
    }
}
