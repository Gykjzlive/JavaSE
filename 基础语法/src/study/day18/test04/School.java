package study.day18.test04;


public class School {
    public static void main(String[] args) {
        double a[] = {9.89, 9.88, 9.99, 9.12, 9.69, 9.76, 8.97};
        double b[] = {89, 56, 78, 90, 100, 77, 56, 45, 36, 79, 98};
        CompurerAverage compurerAverage = new Gymnastics();
        double result = compurerAverage.average(a);
        System.out.println("体操选手最后得分:" + result);
        compurerAverage = new schoolt();
        result = compurerAverage.average(b);
        System.out.println("班级同学平均分:" + result);
    }
}
