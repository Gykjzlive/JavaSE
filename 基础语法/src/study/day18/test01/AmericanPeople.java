package study.day18.test01;

public class AmericanPeople extends People {
    public void americanBoxing() {
        System.out.println("直拳，勾拳，组合拳");
    }

    public void speakHello() {
        System.out.println("How do you do");
    }

    public void averageHeight() {
        height = 176;
        System.out.println("American's average height " + height + "cm");
    }

    public void averageWeight() {
        weight = 75;
        System.out.println("American's average weight " + weight + "kg");
    }
}
