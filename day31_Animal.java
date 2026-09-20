public class Animal {
    protected String name;
    protected int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("[Animal constructor] created " + name);
    }

    void eat() {
        System.out.println(name + " is eating.");
    }

    void sleep() {
        System.out.println(name + " is sleeping.");
    }

    void makeSound() {
        System.out.println(name + " makes a generic animal sound.");
    }

    public static void main(String[] args) {
        Animal genericAnimal = new Animal("Generic Animal", 3);
        genericAnimal.makeSound();

        System.out.println();
        Dog dog = new Dog("Buddy", 4, "Labrador");
        dog.eat();       // inherited from Animal
        dog.makeSound(); // overridden in Dog
        dog.fetch();     // defined only in Dog

        System.out.println();
        Cat cat = new Cat("Whiskers", 2);
        cat.eat();
        cat.makeSound();
        cat.scratch();
    }
}

// 'extends' establishes an "is-a" relationship: a Dog IS an Animal
class Dog extends Animal {
    private String breed;

    Dog(String name, int age, String breed) {
        super(name, age); // must call the parent constructor first — passes shared fields up
        this.breed = breed;
        System.out.println("[Dog constructor] breed: " + breed);
    }

    @Override
    void makeSound() {
        System.out.println(name + " barks: Woof woof!");
    }

    void fetch() {
        System.out.println(name + " fetches the ball.");
    }
}

class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " meows: Meow!");
    }

    void scratch() {
        System.out.println(name + " scratches the post.");
    }
}
