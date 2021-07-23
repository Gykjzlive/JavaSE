package study.day9;

public class test02 {
    public static void main(String[] args) {
        Batter nanfu = new Batter(100);
        Radio radio = new Radio();
        System.out.println("南孚电池的电量是" + nanfu.eler);
        System.out.println("现在要把电池给收音机用");
        radio.openRadio(nanfu);
        System.out.println("现在电池的电量是" + nanfu.eler);
    }
}

class Batter {
    int eler;

    Batter(int amount) {
        eler = amount;
    }
}

class Radio {
    void openRadio(Batter batter) {
        batter.eler = batter.eler - 10;
    }
}