package study.day21;

/**
 如【图1.png】的五星图案节点填上数字：1~12，除去7和11。
 要求每条直线上数字和相等。

 如图就是恰当的填法。

 请你利用计算机搜索所有可能的填法有多少种。
 注意：旋转或镜像后相同的算同一种填法。

 请提交表示方案数目的整数，不要填写任何其它内容。
 */
public class 五星填数 {
    static int count;
    public static void main(String[] args) {
        int [] a={1,2,3,4,5,6,8,9,10,12};
        f(a,0);
        System.out.println(count/10);
    }

    private static void f(int[] a, int index) {
        if (index==a.length-1){
            if(check(a)){
                count++;
            }
            return;
        }
        for (int i = index; i <a.length ; i++) {
            int temp=a[index];
            a[index]=a[i];
            a[i]=temp;
            f(a,index+1);
            temp=a[index];
            a[index]=a[i];
            a[i]=temp;
        }
    }

    private static boolean check(int[] a) {
        int num1=a[1]+a[2]+a[3]+a[4];
        int num2=a[1]+a[5]+a[7]+a[9];
        int num3=a[0]+a[2]+a[5]+a[8];
        int num4=a[0]+a[6]+a[3]+a[9];
        int num5=a[4]+a[6]+a[7]+a[8];
        if (num1==num2&&num2==num3&&num3==num4&&num4==num5){
            return true;
        }
        return false;
    }
}
