package study.day10;

public class test01 {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setRadius(3);
        Circular circular = new Circular();
        System.out.println("circle的引用：" + circle);
        System.out.println("圆锥bottom的作用" + circular.bottom);
        circular.setHeight(5);
        circular.setBottom(circle);
        System.out.println("circle的引用：" + circle);
        System.out.println("圆锥bottom的作用" + circular.bottom);
        System.out.println("圆锥的体积:" + circular.getVolme());
        circle.setRadius(20);
        System.out.println("圆锥bottom的半径" + circular.getBottomRadius());
        circle = new Circle();
        System.out.println("circle的引用：" + circle);
        System.out.println("但是不影响circularde bottom的引用：" + circular.bottom);
        circular.setBottom(circle);
        System.out.println("但是不影响circularde bottom的引用：" + circular.bottom);
    }
}

class Circle {
    int radius;
    double area;

    void setRadius(int r) {
        radius = r;
    }

    int getRadius() {
        return radius;
    }

    double getArea() {
        area = 3.14 * radius * radius;
        return area;
    }
}

class Circular {
    Circle bottom;
    int height;

    void setBottom(Circle c) {
        bottom = c;
    }

    void setHeight(int h) {
        height = h;
    }

    double getVolme() {
        if (bottom == null) {
            return -1;
        } else {
            return bottom.getArea() * height / 3;
        }
    }

    double getBottomRadius() {
        return bottom.getRadius();
    }

    public void setBottomRadius(int r) {
        bottom.setRadius(r);
    }
}