package study.day20;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 2020 年 7 月 1 日是A组织 成立 99 周年纪念日。
 * A组织成立于 1921 年 7 月 23 日。
 * 请问从 1921 年 7 月 23 日中午 12 时到 2020 年 7 月 1 日中午 12 时一共包
 * 含多少分钟？
 * 这是一道结果填空题，你只需要算出结果后提交即可。本题的结果为一个
 * 整数，在提交答案时只填写这个整数，填写多余的内容将无法得分。
 */
public class 纪念日 {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date a = simpleDateFormat.parse("2020-7-1");
        Date b = simpleDateFormat.parse("1921-7-23");
        System.out.println(a);
        System.out.println(b.getTime());

    }
}
