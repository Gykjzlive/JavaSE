package study.day18.test05;

public class Truck {
    ComputeWeight[] goods;
    double totolWights = 0;

    Truck(ComputeWeight[] goods) {
        this.goods = goods;
    }

    public void setGoods(ComputeWeight[] goods) {
        this.goods = goods;
    }

    public double getTotolWights() {
        totolWights = 0;
        for (int i = 0; i < goods.length; i++) {
            totolWights += goods[i].computeWeight();
        }
        return totolWights;
    }
}
