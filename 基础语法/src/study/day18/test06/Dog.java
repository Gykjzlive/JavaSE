package study.day18.test06;

public class Dog {
    DogState state;

    void show() {
        state.showState();
    }

    ;

    void setState(DogState state) {
        this.state = state;
    }
}
