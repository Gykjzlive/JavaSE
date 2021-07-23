package study.day15;

public class Dog implements Animal {
    public void cry() {
        System.out.println("旺旺旺");
    }

    ;

    @Override
    public String getAnimalName() {
        return "小狗";
    }
}
