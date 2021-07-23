package study.day18.test02;

public class test {
    public static void main(String[] args) {
        int amount = 8000;
        ConstructionBank bank1 = new ConstructionBank();
        bank1.savedMoney = amount;
        bank1.year = 8.326;
        bank1.setInterestRate(0.035);
        double interest1 = bank1.computerInterest();
        BankofDalian bank2 = new BankofDalian();
        bank2.savedMoney = amount;
        bank2.year = 8.236;
        bank2.setInterestRate(0.035);
        double interest2 = bank2.computerInterest();
        double money = interest2 - interest1;
        System.out.println("两个银行利息相差" + money + "元");
    }
}
