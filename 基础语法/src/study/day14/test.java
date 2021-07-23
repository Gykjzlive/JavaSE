package study.day14;

public class test {
    public static void main(String[] args) {
        B b = new B();
        double result = b.computer(8, 9, 3);
        System.out.println(result);
    }
}

class A {
    float computer(float x, float y) {
        return x + y;
    }

    public int g(int x, int y) {
        return x + y;
    }
}

class B extends A {
    float computer(float x, float y, double z) {
        return x - y;
    }
}