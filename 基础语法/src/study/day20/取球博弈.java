package study.day20;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 两个人玩取球的游戏。
 * 一共有N个球，每人轮流取球，每次可取集合{n1,n2,n3}中的任何一个数目。
 * 如果无法继续取球，则游戏结束。
 * 此时，持有奇数个球的一方获胜。
 * 如果两人都是奇数，则为平局。
 * <p>
 * 假设双方都采用最聪明的取法，
 * 第一个取球的人一定能赢吗？
 * 试编程解决这个问题。
 * <p>
 * 输入格式：
 * 第一行3个正整数n1 n2 n3，空格分开，表示每次可取的数目 (0<n1,n2,n3<100)
 * 第二行5个正整数x1 x2 ... x5，空格分开，表示5局的初始球数(0<xi<1000)
 * <p>
 * 输出格式：
 * 一行5个字符，空格分开。分别表示每局先取球的人能否获胜。
 * 能获胜则输出+，
 * 次之，如有办法逼平对手，输出0，
 * 无论如何都会输，则输出-
 * <p>
 * 例如，输入：
 * 1 2 3
 * 1 2 3 4 5
 * 程序应该输出：
 * + 0 + 0 -
 * 再例如，输入：
 * 1 4 5
 * 10 11 12 13 15
 * 程序应该输出：
 * 0 - 0 + +
 * 再例如，输入：
 * 2 3 5
 * 7 8 9 10 11
 * 程序应该输出：
 * + 0 0 0 0
 * <p>
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 3000ms
 */
public class 取球博弈 {
    static int[] data = new int[3];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < data.length; i++) {
            data[i] = s.nextInt();
        }
        Arrays.sort(data);
        for (int i = 0; i < 5; i++) {
            int num = s.nextInt();
            char res = f(num, 0, 0);
            System.out.print(res + " ");
        }
    }

    private static char f(int num, int me, int you) {
        if (num < data[0]) {
            if ((me & 1) == 1 && (you & 1) == 0) {
                return '+';
            } else if ((me & 1) == 0 && (you & 1) == 1) {
                return '-';
            } else {
                return '0';
            }

        }
        boolean ping = false;
        for (int i = 0; i < data.length; i++) {
            if (num >= data[i]) {
                char res = f(num - data[i], you, me + data[i]);
                if (res == '-') {
                    return '+';
                }
                if (res == '0') {
                    ping = true;
                }
            }
        }
        if (ping) {
            return '0';
        } else {
            return '-';
        }
    }
}
