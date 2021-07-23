package study.day6;

public class test02 {
    public static void main(String[] args) {
        test02 s = new test02();
        int i, sum = 0;
        for (i = 1; i <= 20; i++) {
            sum += s.test(i);
        }
        System.out.println(sum);
    }

    public static int test(int data) {
        if (data == 1) {
            return 1;
        } else {
            return data * test(data - 1);
        }
    }
}
