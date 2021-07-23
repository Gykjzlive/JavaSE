package study.day18.test02;

public class BankofDalian extends Bank {
    double year;

    double computerInterest() {
        super.year = (int) year;
        double r = year - (int) year;
        int day = (int) (r * 1000);
        double yearInterest = super.computerInterest();
        double dayInterest = day * 0.00012 * savedMoney;
        interest = yearInterest + dayInterest;
        System.out.println(savedMoney + "元存在大连银行" + super.year + "年" + day + "天的利息:" + interest + "元\n");
        return interest;
    }
}
