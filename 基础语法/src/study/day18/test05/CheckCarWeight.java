package study.day18.test05;

public class CheckCarWeight {
    public static void main(String[] args) {
        ComputeWeight[] computeWeights = new ComputeWeight[650];
        for (int i = 0; i < computeWeights.length; i++) {
            if (i % 3 == 0) {
                computeWeights[i] = new TV();
            } else if (i % 3 == 1) {
                computeWeights[i] = new Computer();
            } else if (i % 3 == 2) {
                computeWeights[i] = new Wash();
            }
        }
        Truck truck = new Truck(computeWeights);
        System.out.println(truck.getTotolWights());

    }
}
