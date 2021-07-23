package study.day18.test02;

public class Bank {
    int savedMoney, year;
    double interest;
    double interestRate = 0.29;

    double computerInterest() {
        interest = year * interestRate * savedMoney;
        return interest;
    }

    void setInterestRate(double rate) {
        interestRate = rate;
    }
}
