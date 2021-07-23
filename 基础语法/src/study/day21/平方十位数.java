package study.day21;

/**

 由0~9这10个数字不重复、不遗漏，可以组成很多10位数字。
 这其中也有很多恰好是平方数（是某个数的平方）。

 比如：1026753849，就是其中最小的一个平方数。

 请你找出其中最大的一个平方数是多少？
 */
public class 平方十位数 {
    static long min=Integer.MIN_VALUE;
    static long ans;
    public static void main(String[] args) {
        int [] a={0,1,2,3,4,5,6,7,8,9};
        f(0,a);
        System.out.println(ans);
    }

    private static void f(int i, int[] a) {
        if (i==a.length){
            if (a[0]==0){
                return;
            }
            int c=check(a);
            if(c>min){
                min=c;
                String s="";
                for (int j = 0; j < a.length; j++) {
                    s+=a[j];
                }
                ans=Long.parseLong(s);
            }
            return;
        }
        for (int j = i; j <a.length ; j++) {
            int temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            f(i+1,a);
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
        }
    }

    private static int check(int[] a) {
        String s="";
        for (int j = 0; j <a.length ; j++) {
            s+=a[j];
        }
        long b=Long.parseLong(s);
        double c=Math.sqrt(b);
        String d=String.valueOf(c);
        int index=d.indexOf(".");
        long e=Long.parseLong(d.substring(index+1));
        if(e>0){
            return 0;
        }
        return (int)c;
    }
}
