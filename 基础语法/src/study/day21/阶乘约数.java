package study.day21;


import java.math.BigInteger;

/**
 定义阶乘 n! = 1 × 2 × 3 × ··· × n。

 请问 100! （100 的阶乘）有多少个约数。
 */
public class 阶乘约数 {
    public static void main(String[] args) {
        BigInteger data;
        data=f(BigInteger.valueOf(100));
        System.out.println(factors(data));
    }

    private static long factors(BigInteger data) {
        long res=1,now;
        BigInteger one=BigInteger.valueOf(1);
        for (BigInteger i=BigInteger.valueOf(2); i.multiply(i).compareTo(data)<=0; i=i.add(one)) {
            System.out.println(i);
            now=1;
            while(data.mod(i)==BigInteger.ZERO){
                data=data.divide(i);
                now++;
            }
            if (now>1){
                res*=now;
            }
        }
        return res>1?res*2:res;
    }

    private static BigInteger f(BigInteger i) {
        if(i.equals(BigInteger.valueOf(1))){
            return BigInteger.valueOf(1);
        }
        return i.multiply(f(i.subtract(BigInteger.valueOf(1))));
    }
    
}
