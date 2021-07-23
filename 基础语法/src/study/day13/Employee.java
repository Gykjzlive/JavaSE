package study.day13;

public class Employee {
    String name;
    int salary;
    char id;

    void setter(String a, char c) {
        name = a;
        id = c;
    }

    void setterSalary(int b) {
        salary = b;
    }

    void getter() {
        System.out.println("员工Id：" + id + "\t姓名:" + name + "\t工资:" + salary);
    }
}
