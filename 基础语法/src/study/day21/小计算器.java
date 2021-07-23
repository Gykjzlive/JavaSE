package study.day21;

import java.util.Scanner;

/**
 1. 数字：'NUM X'，X为一个只包含大写字母和数字的字符串，表示一个当前进制的数
 2. 运算指令：'ADD','SUB','MUL','DIV','MOD'，分别表示加减乘，除法取商，除法取余
 3. 进制转换指令：'CHANGE K'，将当前进制转换为K进制(2≤K≤36)
 4. 输出指令：'EQUAL'，以当前进制输出结果
 5. 重置指令：'CLEAR'，清除当前数字

 指令按照以下规则给出：
 数字，运算指令不会连续给出，进制转换指令，输出指令，重置指令有可能连续给出
 运算指令后出现的第一个数字，表示参与运算的数字。且在该运算指令和该数字中间不会出现运算指令和输出指令
 重置指令后出现的第一个数字，表示基础值。且在重置指令和第一个数字中间不会出现运算指令和输出指令
 进制转换指令可能出现在任何地方

 运算过程中中间变量均为非负整数，且小于2^63。
 以大写的'A'~'Z'表示10~35

 [输入格式]
 第1行：1个n，表示指令数量
 第2..n+1行：每行给出一条指令。指令序列一定以'CLEAR'作为开始，并且满足指令规则

 [输出格式]
 依次给出每一次'EQUAL'得到的结果

 输入:
 7
 CLEAR
 NUM 1024
 CHANGE 2
 ADD
 NUM 100000
 CHANGE 8
 EQUAL
 输出：
 2040
 */
public class 小计算器 {
    static int cur_system=10;
    static int next_system;
    static int startIndex;
    static int endIndex;
    static int index;
    static int a[];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        a=new int[n];
        scanner.nextLine();
        String[] data=new String[n];
        for (int i = 0; i <n ; i++) {
            data[i]=scanner.nextLine();
        }
        for (int i = 0; i <n; i++) {
            int system=cur_system;
            String s=data[i];
            if(s.startsWith("CLE")){
                
            }
        }
    }
}
