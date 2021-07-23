package base;

import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
//        System.out.println("hello,world");
//        float a = 0.1f;
//        System.out.println(a);
//        float b = 2333224352525f;
//        float c = b+1;
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(b==c);
        Scanner s = new Scanner(System.in);
        System.out.println("请输入第一个数字:");
        int numOne = s.nextInt();
        System.out.println("请输入运算符号:");
        String op = s.next();
        System.out.println("请输入第二个数字:");
        int numTwo = s.nextInt();
        int result = 0;
        switch (op) {
            case "+":
                result = numOne + numTwo;
                break;
            case "-":
                result = numOne - numTwo;
                break;
            case "*":
                result = numOne * numTwo;
                break;
            case "/":
                result = numOne / numTwo;
                break;
            default:
                System.out.println("输入的数不符合规范");
        }
        System.out.println("result:" + result);
        s.close();
    }
}
