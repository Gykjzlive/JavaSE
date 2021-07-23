package study.day21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 小蓝特别喜欢单调递增的事物。
 在一个字符串中，如果取出若干个字符，将这些字符按照在字符串中的顺
 序排列后是单调递增的，则成为这个字符串中的一个单调递增子序列。
 例如，在字符串 lanqiao 中，如果取出字符 n 和 q，则 nq 组成一个单
 调递增子序列。类似的单调递增子序列还有 lnq、 i、 ano 等等。
 小蓝发现，有些子序列虽然位置不同，但是字符序列是一样的，例如取第
 二个字符和最后一个字符可以取到 ao，取最后两个字符也可以取到 ao。小蓝
 认为他们并没有本质不同。
 对于一个字符串，小蓝想知道，本质不同的递增子序列有多少个？
 例如，对于字符串 lanqiao，本质不同的递增子序列有 21 个。它们分别
 是 l、 a、 n、 q、 i、 o、 ln、 an、 lq、 aq、 nq、 ai、 lo、 ao、 no、 io、 lnq、anq、 lno、 ano、 aio。
 请问对于以下字符串（共 200 个小写英文字母，分四行显示）：（如果你把
 以下文字复制到文本文件中，请务必检查复制的内容是否与文档中的一致。在
 试题目录下有一个文件 inc.txt，内容与下面的文本相同）
 tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhf
 iadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqij
 gihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmad
 vrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl
 本质不同的递增子序列有多少个？
 */
public class 本质上升序列 {
    static int[] arr=new int[200];
    public static void main(String[] args) {
        String data = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmadvrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
        ArrayList<String> arrayList=new ArrayList<>();
        for (int i = 0; i <200 ; i++) {
            if(arrayList.isEmpty()){
                arrayList.add(""+data.charAt(i));
                arr[i]=1;
            }
            if (arrayList.indexOf(""+data.charAt(i))<0){
                arrayList.add(""+data.charAt(i));
                arr[i]=1;
            }
        }
        for (int i = 0; i <200 ; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (data.charAt(i)>data.charAt(j)){
                    arr[i]+=arr[j];
                }
                if (data.charAt(i)==data.charAt(j)){
                    break;
                }
            }
        }
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
        }
        System.out.println(sum);
    }
}
