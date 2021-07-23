package study.day14;

public class test02 {
    public static void main(String[] args) {
        D d = new D();
        Integer t = d.get();
        System.out.println(t.intValue());
    }
}

class C {
    Object get() {
        return null;
    }
}

class D extends C {
    Integer get() {
        super.get();
        return new Integer(100);
    }
}
