package study.day15;

public class Application {
    public static void main(String[] args) {
        Simulator simulator = new Simulator();
        Animal animal;
        animal = new Dog();
        simulator.useAnimal(animal);
        simulator.playSound();
        animal = new Cat();
        simulator.useAnimal(animal);
        simulator.playSound();
    }
}
