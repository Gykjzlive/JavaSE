package study.day9;

public class test01 {
    public static void main(String[] args) {
        Sum s = new Sum(2, 3);
        Sum s2 = new Sum(5, 6);
        int a = s.get();
        int b = s2.get();
        int c = s2.z();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}

class Sum {
    int x, y;

    Sum(int a, int b) {
        x = a;
        y = b;
    }

    int get() {
        return x * y;
    }

    int z() {
        return 2 * (x + y);
    }
}