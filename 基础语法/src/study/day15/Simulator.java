package study.day15;

public class Simulator {
    Animal animal;

    public void useAnimal(Animal animal) {
        this.animal = animal;
    }

    ;

    public void playSound() {
        System.out.println("我的种类是" + animal.getAnimalName() + "\t我的叫声是:");
        animal.cry();
    }
}
