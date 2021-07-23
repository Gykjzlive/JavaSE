package study.day23;

import java.util.ArrayList;

/**
 将 2019 拆分为若干个两两不同的完全平方数之和，一共有多少种不同的方法？
 注意交换顺序视为同一种方法，例如 13^2 + 25^2 + 35^2 = 2019 与 13^2 + 35^2 +25^2 = 2019 视为同一种方法。
 【答案提交】
 这是一道结果填空的题，你只需要算出结果后提交即可。本题的结果为一
 个整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。

 */
public class 平方拆分 {
    static int count;
    public static void main(String[] args) {
        ArrayList<Integer> data=new ArrayList<>();
        dfs(data,0,2019);
        System.out.println(count*2);
    }

    private static void dfs(ArrayList<Integer> data, int cur, int n) {
        if (n==0){
            count++;
            return;
        }
        for (int i = cur+1; i*i<=n ; i++) {
            data.add(i);
            dfs(data,i,n-(i*i));
            data.remove(data.size()-1);
        }
    }

}
