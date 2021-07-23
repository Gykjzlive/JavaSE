package study.day19.dataStruct;

import java.util.Iterator;
import java.util.Scanner;

/**
 * @author 蟑螂恶霸
 * @version 1.0
 * @description: ArrayTest测试类
 * @date 2021/4/3 14:45
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<String>();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String data = s.next();
            if (data.equals("esc")) {
                break;
            }
            if (data.equals("-")) {
                arrayStack.pop();
            } else {
                arrayStack.push(data);
            }
        }
        System.out.println(arrayStack.size());
        Iterator<String> i = arrayStack.iterator();
        while (i.hasNext()) {
            String a = i.next();
            System.out.print(a + " ");
        }
    }
}
