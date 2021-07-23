package study.day20;


import java.util.*;

/**
 * 小明维护着一个程序员论坛。现在他收集了一份"点赞"日志，日志共有N行。其中每一行的格式是：
 * <p>
 * ts id
 * <p>
 * 表示在ts时刻编号id的帖子收到一个"赞"。
 * <p>
 * 现在小明想统计有哪些帖子曾经是"热帖"。如果一个帖子曾在任意一个长度为D的时间段内收到不少于K个赞，小明就认为这个帖子曾是"热帖"。
 * <p>
 * 具体来说，如果存在某个时刻T满足该帖在[T, T+D)这段时间内(注意是左闭右开区间)收到不少于K个赞，该帖就曾是"热帖"。
 * <p>
 * 给定日志，请你帮助小明统计出所有曾是"热帖"的帖子编号。
 * <p>
 * 【输入格式】
 * 第一行包含三个整数N、D和K。
 * 以下N行每行一条日志，包含两个整数ts和id。
 * <p>
 * 对于50%的数据，1 <= K <= N <= 1000
 * 对于100%的数据，1 <= K <= N <= 100000 0 <= ts <= 100000 0 <= id <= 100000
 * <p>
 * 【输出格式】
 * 按从小到大的顺序输出热帖id。每个id一行。
 * <p>
 * 【输入样例】
 * 7 10 2
 * 0 1
 * 0 10
 * 10 10
 * 10 1
 * 9 1
 * 100 3
 * 100 3
 * <p>
 * 【输出样例】
 * 1
 * 3
 */
public class 日志统计 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n, d, k;
        n = s.nextInt();
        d = s.nextInt();
        k = s.nextInt();
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++) {
            int ts = s.nextInt();
            int id = s.nextInt();
            if (map.containsKey(id)) {
                List<Integer> list = map.get(id);
                list.add(ts);
                map.put(id, list);
            } else {
                List<Integer> list = new ArrayList();
                list.add(ts);
                map.put(id, list);
            }
        }
        List<Integer> list = new ArrayList();
        for (int key : map.keySet()) {
            List<Integer> list1 = map.get(key);
            Collections.sort(list1);
            int count = 0;
            for (int i = 0; i < list1.size(); i++) {
                for (int j = 0; j < list1.size(); j++) {
                    if (j == i) continue;
                    if (Math.abs(list1.get(j) - list1.get(i)) < d) {
                        count++;
                    }
                    if (count >= k) {
                        list.add(key);
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) - list.get(i - 1) == 0) {
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}
