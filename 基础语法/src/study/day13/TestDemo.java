package study.day13;

public class TestDemo {
    public static void main(String[] args) {
        Employee employeeOne = new Employee();
        employeeOne.setter("孙大炮", '2');
        employeeOne.setterSalary(2500);
        employeeOne.getter();
        Manager manager = new Manager(1000000);
        manager.setterSalary(20000);
        manager.setterJob("老板");
        manager.setter("寇大仙", '1');
        manager.getter();
    }
}
