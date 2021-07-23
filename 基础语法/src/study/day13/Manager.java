package study.day13;

public class Manager extends Employee {
    int jj;
    String job;

    Manager(int a) {
        jj = a;
    }

    void setterSalary(int b) {
        salary = b + jj;
    }

    void setterJob(String a) {
        job = a;
    }

    void getterJob() {
        System.out.println(job);
    }

    void getter() {
        System.out.println("员工Id：" + id + "\t姓名:" + name + "\t职务:" + job + "\t工资:" + salary);
    }
}
