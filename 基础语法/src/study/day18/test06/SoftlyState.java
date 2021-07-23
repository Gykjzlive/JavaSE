package study.day18.test06;

public class SoftlyState implements DogState {
    @Override
    public void showState() {
        System.out.println("听主人的命令");
    }
}
