package study.day12;

public class Student {
    int number;

    Student(int n) {
        number = n;
    }

    void speak() {
        System.out.println("Student得包名是study.day12:学号是" + number);
    }
}
