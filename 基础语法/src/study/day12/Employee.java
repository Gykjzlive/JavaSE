package study.day12;

public class Employee {
    private String name;
    private float salary;
    private int id;

    Employee(String a, float b, int c) {
        name = a;
        salary = b;
        id = c;
    }

    void setData(String a, float b, int c) {
        name = a;
        salary = b;
        id = c;
    }

    void getData() {
        System.out.println("员工编号:" + id + "\t姓名:" + name + "\t薪水:" + salary);
    }
}
