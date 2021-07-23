package study.day23;

import java.math.BigInteger;

/**
 定义阶乘 n! = 1 × 2 × 3 × ··· × n。

 请问 100! （100 的阶乘）有多少个约数。
 */
public class 阶乘约数 {
    public static void main(String[] args) {
        BigInteger data=f(BigInteger.valueOf(100));
        System.out.println(data);
        BigInteger count=factors(data);
        System.out.println(count);
    }

    private static BigInteger factors(BigInteger n) {
        BigInteger res=BigInteger.ONE;
        BigInteger now;
        for (BigInteger i=BigInteger.valueOf(2);(i.multiply(i).compareTo(n))<=0  ; i=i.add(BigInteger.valueOf(1))) {
            now=BigInteger.valueOf(1);
            while((n.mod(i).compareTo(BigInteger.valueOf(0)))==0){
                n=n.divide(i);
                now=now.add(BigInteger.valueOf(1));
            }
            if (now.compareTo(BigInteger.valueOf(1))>0){
                res=res.multiply(now);
            }
        }
        return n.compareTo(BigInteger.valueOf(1))>0?res.multiply(BigInteger.valueOf(2)):res;
    }

    private static BigInteger f(BigInteger n) {
        if(n.compareTo(BigInteger.valueOf(1))==0){
            return BigInteger.valueOf(1);
        }
        return n.multiply(f(n.subtract(BigInteger.valueOf(1))));
    }


}
