package study.day19.dataStruct;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: 链表实现栈测试
 * @date 2021/4/3 16:08
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String data = s.next();
            if (data.equals("esc")) {
                break;
            }
            if (data.equals("-")) {
                stack.pop();
            } else {
                stack.push(data);
            }
        }
        System.out.println(stack.size());
        Iterator<String> i = stack.iterator();
        while (i.hasNext()) {
            String a = i.next();
            System.out.print(a + " ");
        }
    }
}
