package study.day11;

public class people {
    double sg;
    String xm;
    char xb;

    people(double a, String b, char c) {
        sg = a;
        xm = b;
        xb = c;
    }

    void rwjj() {
        System.out.println(xm + " " + xb + " " + "身高" + sg);
//        return 0;
    }
}
