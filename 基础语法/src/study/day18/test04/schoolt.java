package study.day18.test04;

public class schoolt implements CompurerAverage {
    @Override
    public double average(double[] x) {
        double aver = 0;
        for (int i = 0; i < x.length; i++) {
            aver += x[i];
        }
        aver = aver / x.length;
        return aver;
    }
}
